import java.io.*;
import java.net.*;
import java.util.*;

public class 팔반쿠드롱_송인재_박가영 {
    
    /*
     * 8반 당구 최강자 쿠드롱 전략
     * 
     * 홀 번호
     * 1 ----- 2 ----- 3
     * |               |
     * |               |
     * |               |
     * 4 ----- 5 ----- 6
     * 
     * 1. 공 선정
     *   - 내 공과 목표 공을 비교해서 각 홀에 대한 가능성으로 분기처리
     *   - ex) 내 공이 타겟공보다 뒤에 있는 경우 -> 2, 3, 5, 6 가능
     *   - => 내 공이 타겟공보다 위에 있는 경우 -> 5, 6 가능 / 아래에 있는 경우 -> 2, 3 가능
     *   - => 공이 홀에 절대 못 들어가는 경우 -> 홀 2, 홀 5보다 앞에 있는 경우 -> 3, 6 가능
     *   - 등등..
     *   
     *   - 분기 처리로 홀까지의 거리 계산 후 가장 거리가 짧은 홀-목적구 세트 조준
     *   
     * 2. 각도 계산
     *   - 홀과 목적구의 각도 == 목적구와 내 공의 목적지의 각도
     *   - 라는 점을 이용해 내 공의 목적지 좌표 계산
     *   - 이후 목적지 좌표와 현재 흰 공의 좌표로 각도 계산
     *   
     * 3. 파워
     *   - 파워 != 목적지와 현재 공의 거리
     *   - ex) 내 공 ~ 목적지 : 1cm / 목적구 ~ 홀 : 10cm => 파워 부족
     *   - 목적지와 현재 공의 거리, 그리고 목표하는 목적구와 홀과의 거리 중 큰 값을 3으로 나눔
     *   - 실제 파워는 더 작아야 공이 비교적 정확하게 들어가기 때문!
     *   
     * 4. 파울 유도 (보류)
     *   - 목적구와 검정공이 가까운 경우엔 목적구를 홀에 넣기가 힘듬
     *   - 이럴 땐 파울 없이 목적구에 최대한 가깝게 유지 시도
     *   - 우리 팀의 목적구 + 8번 공과 최대한 밀접시켜 상대방의 파울 유도
     */

    // ?땳?꽕?엫?쓣 ?궗?슜?옄?뿉 留욊쾶 蹂?寃쏀빐 二쇱꽭?슂.
    static final String NICKNAME = "팔반쿠드롱";
    
    // ?씪???떥?뵾 ?봽濡쒓렇?옩?쓣 濡쒖뺄?뿉?꽌 ?떎?뻾?븷 寃쎌슦 蹂?寃쏀븯吏? ?븡?뒿?땲?떎.
    static final String HOST = "127.0.0.1";

    // ?씪???떥?뵾 ?봽濡쒓렇?옩怨? ?넻?떊?븷 ?븣 ?궗?슜?븯?뒗 肄붾뱶媛믪쑝濡? 蹂?寃쏀븯吏? ?븡?뒿?땲?떎.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 寃뚯엫 ?솚寃쎌뿉 ???븳 ?긽?닔?엯?땲?떎.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final double RADIUS = 5.145 / 2;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = { { 0, 127 }, { 127, 127 }, { 254, 127 }, { 0, 0 }, { 127, 0 }, { 254, 0 } };

    public static void main(String[] args) {
        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int)balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                // whiteBall_x, whiteBall_y: ?씛 怨듭쓽 X, Y醫뚰몴瑜? ?굹???궡湲? ?쐞?빐 ?궗?슜?븳 蹂??닔
                float whiteBall_x = balls[0][0];
                float whiteBall_y = balls[0][1];
                
                // 우리팀 공 등록
                Set<Integer> myBalls = new HashSet<>();
                
                if (order == 1) {
                    myBalls.add(1);
                    myBalls.add(3);
                } else {
                    myBalls.add(2);
                    myBalls.add(4);
                }
                
                myBalls.add(5);
                
                // 공&홀 선정
                int[] goalIndices = getGoal(whiteBall_x, whiteBall_y, myBalls, balls);
                int[] hole = HOLES[goalIndices[0]];
                float[] target = balls[goalIndices[1]];
                
                // 각도 & 파워 계산
                float[] data = getData(hole, target, whiteBall_x, whiteBall_y);
                angle = data[0];
                
                // 파워 조정
                power = data[1];
//                power = readjustPower(target, balls, whiteBall_x, whiteBall_y, hole, data[1]);
                
                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);

            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static float readjustPower(float[] target, float[][] balls, float whiteBall_x, float whiteBall_y, int[] hole, float power) {
        float[] lastBall = balls[5];
        
        if (lastBall != target) {
            double lastDistance = getDistance(target, lastBall);
            
            if (lastDistance <= 10) {
                double ballToTarget = getDistance(target,  new float[] {whiteBall_x, whiteBall_y});
                double targetToHole = getDistance(target, new float[] {hole[0], hole[1]});
                System.out.println("작전 중");
                
                return (float) Math.min(ballToTarget, targetToHole) / 3.5F;
            }
        }
        
        return power;
    }
    
    static int[] getGoal(float whiteBall_x, float whiteBall_y, Set<Integer> myBalls, float[][] balls) {
        int holeIndex = 0;
        int ballIndex = 0;
        double minDistance = Integer.MAX_VALUE;
        
        for (int i = 1; i < balls.length; i++) {
            if (balls[i][0] == -1 || !myBalls.contains(i)) { // 유효하지 않은 공이면 무시
                continue;
            }
            
            if (minDistance != Integer.MAX_VALUE && i == balls.length - 1) { // 마지막이 아닐 땐 8번 공 무시
                continue;
            }
            
            float ballX = balls[i][0];
            float ballY = balls[i][1];
            
            int holeStart = 1;
            int holeLimit = 3;
            
            // 가능한 홀 탐색
            // 타겟 공이 흰 공보다 뒤에 있는 경우
            if (ballX < whiteBall_x) {
                
                // 타겟 공이 흰 공보다 아래에 있는 경우
                if (ballY < whiteBall_y) {
                    holeStart = 3;
                    holeLimit = 5;
                    
                    if (ballY > 15 && HOLES[4][0] > ballX) {
                        holeLimit = 4;
                    }
                } else { // 타겟 공이 흰 공보다 위에 있는 경우
                    holeStart = 0;
                    holeLimit = 2;
                    
                    if (ballY < 112 && HOLES[2][0] > ballX) {
                        holeLimit = 1;
                    }
                }
            } else { // 타겟 공이 흰 공보다 앞에 있는 경우
                if (ballY < whiteBall_y) { // 타겟 공이 흰 공보다 아래에 있는 경우
                    holeStart = 4;
                    holeLimit = 6;
                    
                    if (HOLES[4][0] < ballX) {
                        holeStart = 5;
                    }
                } else { // 타겟 공이 흰 공보다 위에 있는 경우
                    if (HOLES[1][0] < ballX) {
                        holeStart = 2;
                    }
                }
            }
            
            // 최소 거리 계산
            for (int j = holeStart; j < holeLimit; j++) {
                double dist = getDistance(new float[] {HOLES[j][0], HOLES[j][1]}, balls[i]);
                
                if (minDistance > dist) {
                    minDistance = dist;
                    holeIndex = j;
                    ballIndex = i;
                }
            }
        }
        
        return new int[] {holeIndex, ballIndex};
    }
    
    static float[] getData(int[] hole, float[] target, float whiteBall_x, float whiteBall_y) {
        float angle = 0.0f;
        float power = 0.0f;
        
        // 홀과 타겟 사이의 각도 (theta) 구하기
        double holeToTargetAngle = getTheta(hole, target);
        
        // 목적지 좌표 구하기
        double[] destination = getDestination(hole, target, holeToTargetAngle);
        double destinationX = destination[0];
        double destinationY = destination[1];
        
        // 공 각도 구하기
        double xDiff = destinationX - whiteBall_x;
        double yDiff = destinationY - whiteBall_y;
        double phi = Math.atan(yDiff / xDiff);        
        angle = getAngle(xDiff, yDiff, phi);
        
        // 공 거리 구하기
        double holeTargetDistance = getDistance(new float[] {hole[0], hole[1]}, target);
        double ballDestinationDist = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

        // 최대 파워 정하기
        power = (float) Math.max(holeTargetDistance, ballDestinationDist) / 3;
        
        return new float[] {angle, power};
    }
    
    static float getAngle(double xDiff, double yDiff, double phi) {
        float angle = 0.0f;
        
        // 4분면 별 각도 재 계산
        if (xDiff >= 0 && yDiff >= 0) {
            angle = (float) Math.toDegrees(Math.PI / 2 - phi);
        } else if (xDiff >= 0 && yDiff < 0) {
            angle = (float) Math.toDegrees(Math.PI / 2 + phi* -1);
        } else if (xDiff < 0 && yDiff < 0) {
            angle = (float) Math.toDegrees(-Math.PI / 2 - phi);
        } else {
            angle = (float) Math.toDegrees((Math.PI / 2 + phi) * -1);
        }
        
        return angle;
    }
    
    static double getTheta(int[] hole, float[] target) {
        double holeToTargetX = Math.abs(hole[0] - target[0]);
        double holeToTargetY = Math.abs(hole[1] - target[1]);

        return Math.atan(holeToTargetX / holeToTargetY);
    }
    
    static double[] getDestination(int[] hole, float[] target, double theta) {
        double targetDestinationSin = 2 * RADIUS * Math.sin(theta);
        double targetDestinationCos = 2 * RADIUS * Math.cos(theta);
        double destinationX = hole[0] > target[0] ? target[0] - targetDestinationSin : target[0] + targetDestinationSin;
        double destinationY = hole[1] > target[1] ? target[1] - targetDestinationCos : target[1] + targetDestinationCos;
        
        if (hole[0] == target[0]) {
            destinationX = target[0];
            destinationY = hole[1] == 0 ? target[1] + 2 * RADIUS : target[1] - 2 * RADIUS;
        }
        
        return new double[] {destinationX, destinationY};
    }
    
    static double getDistance(float[] start, float[] destination) {
        double xDiffSq = Math.pow(start[0] - destination[0], 2);
        double yDiffSq = Math.pow(start[1] - destination[1], 2);
        
        return Math.sqrt(xDiffSq + yDiffSq);
    }
}