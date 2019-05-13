package phiDiEulero;

import java.util.Scanner;

public class PhiMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		String risp = sc.nextLine();
		boolean c = true;
		while (c) {
			c = false;
			try {
				int valore = Integer.parseInt(risp);
				System.out.println("La phi di Eulero del numero "+ valore +" è "+ phi(valore));
			}catch(NumberFormatException e) {
				System.out.println("Devi inserire un numero !");
				c = true;
			}
		}
	}
	
	public static Integer phi(int num) {
		int[] risCaso2 = caso2(num);
		int[] risCaso1 = caso1(num);
		if(risCaso1 != null) {
			return ((risCaso1[0]-1)* (int)Math.pow(risCaso1[0], risCaso1[1]-1) );
		}else if(risCaso2!=null) {
			return phi(risCaso2[0] * risCaso2[1]);
		}else return null; //nessuno dei casi � contemplato
	}
	
	public static int[] caso1(int n) {
		int p, k;
		for(p =2;p<n;p++) {
            if(isPrimo(p)) {
                k = 0;
                int potenza = 0;
                while(potenza < n) {
                     potenza =(int) Math.pow(p, k);
                     if(potenza == n) {
                    	 int vett[] = {p, k};
                    	 return vett;
                     }
                     k++;
                }
            }
		}
		return null;
	}
	
	public static int[] caso2(int n) {
		int a, b;
		for(a=1; a<=n; a++) {
			for(b=1; b<n; b++) {
				if(a*b == n && mcd(a, b) == 1) {
					int vett[] = {a,b};
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
	
    public static boolean isPrimo(int p) {
        for(int x = 2;x<=p;x++) {
            if(p%x == 0 && x!=p) return false;
        }
        return true;
    }
}