package DAY_08.B형대비.신소재케이블2;

import java.util.HashMap;

public class UserSolution {
    static final int MAX_DEVICE = 10005;
    int root, id;

    int[] parent = new int[MAX_DEVICE];
    int[] distToParent = new int[MAX_DEVICE];
    int[] depth = new int[MAX_DEVICE];

    int[] firstID = new int[MAX_DEVICE], secondID = new int[MAX_DEVICE];
    int[] firstLatency = new int[MAX_DEVICE], secondLatency = new int[MAX_DEVICE];

    HashMap<Integer, Integer> idmap = new HashMap<>();

    public void init(int mDevice) {
        for (int i = 0; i <= id; i++) {
            firstLatency[i] = secondLatency[i] = 0;
        }
        root = id = 1;
        idmap.clear();
        idmap.put(mDevice, id);
    }

    private void update(int pid, int cid) {
        int distSum = 0;
        while (pid != 0) {
            distSum += distToParent[cid];
            if (firstID[pid] == cid) {
                if (firstLatency[pid] < distSum)
                    firstLatency[pid] = distSum;
                else
                    break;
            } else if (firstLatency[pid] < distSum) {
                secondLatency[pid] = firstLatency[pid];
                secondID[pid] = firstID[pid];
                firstLatency[pid] = distSum;
                firstID[pid] = cid;
            } else if (secondLatency[pid] < distSum) {
                secondLatency[pid] = distSum;
                secondID[pid] = cid;
            } else {
                break;
            }

            cid = pid;
            pid = parent[pid];
        }
    }

    public void connect(int mOldDevice, int mNewDevice, int mLatency) {
        int oldDeviceId = idmap.get(mOldDevice);
        int newDeviceId = ++id;

        idmap.put(mNewDevice, newDeviceId);

        parent[newDeviceId] = oldDeviceId;
        depth[newDeviceId] = depth[oldDeviceId] + 1;
        distToParent[newDeviceId] = mLatency;

        update(oldDeviceId, newDeviceId);
    }

    public int measure(int mDevice1, int mDevice2) {
        int sid = idmap.get(mDevice1);
        int eid = idmap.get(mDevice2);

        if (depth[sid] > depth[eid]) {
            int temp = sid;
            sid = eid;
            eid = temp;
        }
        int diff = depth[eid] - depth[sid];
        int ret = 0;

        while (diff-- > 0) {
            ret += distToParent[eid];
            eid = parent[eid];
        }
        while (sid != eid) {
            ret += distToParent[sid] + distToParent[eid];
            sid = parent[sid];
            eid = parent[eid];
        }
        return ret;
    }

    public int test(int mDevice) {
        int mid = idmap.get(mDevice);
        int pid = parent[mid];
        int ret = firstLatency[mid] + secondLatency[mid];

        int distSum = firstLatency[mid];
        while (pid != 0) {
            distSum += distToParent[mid];
            if (secondLatency[pid] != 0) {
                if (firstID[pid] == mid) {
                    ret = Math.max(ret, distSum + secondLatency[pid]);
                } else {
                    ret = Math.max(ret, distSum + firstLatency[pid]);
                }
            } else {
                ret = Math.max(ret, distSum);
            }
            mid = pid;
            pid = parent[pid];
        }
        return ret;
    }
}
