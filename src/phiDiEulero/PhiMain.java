package phiDiEulero;

public class PhiMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int[] f2(int n) {
		int a, b;
		for(a=1; a<=n; a++) {
			for(b=1; b<n; b++) {
				if(a*b == n && mcd(a, b) == 1) {
					int vett[] = {a, b};
					return vett;
				}
			}
		}
		return null;
	}


public static int mcd(int a, int b) {
	  if(b==0) return(a);
	  else return mcd(b,a%b);
	}

}