import java.net.*;
import java.io.*;

public class MGWJ_김민경_오완진 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "MGWJ";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

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

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

// --------------------------------------------------------------------------------------------------------------------------

				// 흰 공 X, Y 좌표
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];
				
				// 목적구/상대구 (1->3, 2->4)
				float targetBall_x = -1;
				float targetBall_y = -1;
				
				// 선공-후공 ~ 1 or 2 존재 여부 ~ 3 or 4 결정
				int targetIdx = 0;
				if (order == 1) {	// 선공
					if (balls[1][0] > 0) {
						targetIdx = 1;
						targetBall_x = balls[1][0];
						targetBall_y = balls[1][1];
					} else if (balls[3][0] > 0) {
						targetIdx = 3;
						targetBall_x = balls[3][0];
						targetBall_y = balls[3][1];
					} else {
						targetIdx = 5;
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				} else {			// 후공
					if (balls[2][0] > 0) {
						targetIdx = 2;
						targetBall_x = balls[2][0];
						targetBall_y = balls[2][1];
					} else if (balls[4][0] > 0) {
						targetIdx = 4;
						targetBall_x = balls[4][0];
						targetBall_y = balls[4][1];
					} else {
						targetIdx = 5;
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				}
				
				
				// 타겟볼과 가장 가까운 홀의 좌표값 찾기
				float minHoleDistance = 9999;
				float minHole_x = 9999;
				float minHole_y = 9999;
				int holeIdx = 0;
				for (int i = 0; i < 6; i++) {
					float holeDistance = calDistance(targetBall_x, targetBall_y, HOLES[i][0], HOLES[i][1]);
					if (whiteBall_x < 127 && 127 < targetBall_x || targetBall_x < 127 && 127 < whiteBall_x) {
						if (i == 1) continue;
						if (i == 4) continue;
					}
					if (minHoleDistance > holeDistance) {
						minHoleDistance = holeDistance;
						holeIdx = i;
						minHole_x = HOLES[i][0];
						minHole_y = HOLES[i][1];
					}
				}
				
				System.out.println("---------------------------");
				System.out.println("targetIdx: " + targetIdx);
				System.out.println("holeIdx: " + holeIdx);
				System.out.println("---------------------------");
				
				
				// 목적구가 상하좌우로 일직선 상에 위치
//				if (whiteBall_x == targetBall_x) {
//					if (whiteBall_y < targetBall_y)	angle = 0;
//					else							angle = 180;
//				}
//				else if (whiteBall_y == targetBall_y) {
//					if (whiteBall_x < targetBall_x)	angle = 90;
//					else							angle = 270;
//				}
//				else {
					float[] hitBall = new float[2];
					hitBall = calHitBall(targetBall_x, targetBall_y, minHole_x, minHole_y);
					double doubleAngle = calAngle(whiteBall_x, whiteBall_y, hitBall);
					angle = (float) doubleAngle;
//				}
				
				power = (float)(calDistance(whiteBall_x, whiteBall_y, hitBall[0], hitBall[1]));
				
// --------------------------------------------------------------------------------------------------------------------------
				
				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

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
	
	static float calDistance(float x1, float y1, float x2, float y2) {
		float x1x2 = Math.abs(x1 - x2);
		float y1y2 = Math.abs(y1 - y2);
		float distance = (float) Math.sqrt(x1x2*x1x2 + y1y2*y1y2);
		return distance;
	}
	
	static float[] calHitBall(float x1, float y1, float x2, float y2) {
		
	    final float R = 5.73f;

	    float distance = calDistance(x1, y1, x2, y2);
	    // 단위벡터
	    float unitVector_x = ((x2 - x1) / distance) * R;
	    float unitVector_y = ((y2 - y1) / distance) * R;
	    // hitBall[][]
	    float[] hitBall = new float[2];
	    hitBall[0] = x1 + unitVector_x;
	    hitBall[1] = y1 + unitVector_y;
	    
		System.out.println("---------------------------");
	    System.out.println("hitBall: " + hitBall[0] + ", " + hitBall[1]);
		System.out.println("---------------------------");
	    return hitBall;
		
	}
	
	static float calAngle(float whiteBall_x, float whiteBall_y, float[] hitBall) {
		
		float hitBall_x = hitBall[0];
		float hitBall_y = hitBall[1];
		float dx = (float) Math.abs(hitBall_x - whiteBall_x);
		float dy = (float) Math.abs(hitBall_y - whiteBall_y);
		float angle = 0;
		
		if (whiteBall_x < hitBall_x) {
			if (whiteBall_y < hitBall_y) {		// 1사분면
				angle = (float) (Math.toDegrees(Math.atan(dx / dy)));
			} else {							// 4사분면
				angle = (float) (Math.toDegrees((Math.atan(dy / dx) + 90)));
			}
		} else {
			if (whiteBall_y > hitBall_y) {		// 3사분면
				angle = (float) (Math.toDegrees((Math.atan(dx / dy) + 180)));
			} else {							// 2사분면
				angle = (float) (Math.toDegrees((Math.atan(dy / dx) + 270)));
			}
		}
		
		return angle;
		
	}
	
}
