package test;

public class Practice {
	public static void main(String[] args) {
		
		System.out.println(Math.PI);
		double ar = Math.acos(1.0/2);	// >> 0? 0.5? 주의
		System.out.println(ar);
		double ad = Math.toDegrees(ar);
		System.out.println(ad);
		
		int a = 3;
		int b = 4;
		System.out.println(Math.pow(a, 2));
		System.out.println(a*a);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		System.out.println(c);
		
        double x1 = 5.0;
        double y1 = 4.0;
        double x2 = 5.0;
        double y2 = -4.0;
        double x3 = -5.0;
        double y3 = -4.0;
        double x4 = -5.0;
        double y4 = 4.0;

        System.out.println("Theta for (x1, y1): " + calculateTheta(x1, y1)); // 예상: 0~90도
        System.out.println("Theta for (x2, y2): " + calculateTheta(x2, y2)); // 예상: 90~180도
        System.out.println("Theta for (x3, y3): " + calculateTheta(x3, y3)); // 예상: 180~270도
        System.out.println("Theta for (x4, y4): " + calculateTheta(x4, y4)); // 예상: 270~360도
    }
	
    public static double calculateTheta(double x, double y) {
    	// atan 대신 atan2 사용
        double theta = Math.toDegrees(Math.atan2(x, y));

        // 각도가 음수일 경우 360도를 더해 0~360도 범위로 조정
        if (theta < 0) {
            theta += 360;
        }

        return theta;
    }

}