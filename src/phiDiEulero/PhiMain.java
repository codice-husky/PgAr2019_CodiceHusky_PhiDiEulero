package phiDiEulero;

import java.util.Scanner;

public class PhiMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		do {
			try {
				System.out.print("Inserisci un numero: ");
				String risp = sc.nextLine();
				int valore = Integer.parseInt(risp);
				if(valore >1) {
					System.out.println("La phi di Eulero del numero "+ valore +" è "+ phi(valore));
					break;
				}else {
					System.out.println("Devi inserire un numero maggiore di 1 ");
				}
			}catch(NumberFormatException e) {
				System.out.println("Devi inserire un numero !");
			}
		} while(true);
	}
	
	public static Integer phi(int num) {
		int[] risCaso2 = caso2(num);
		int[] risCaso1 = caso1(num);
		if(risCaso1 != null) {
			return ((risCaso1[0]-1)* (int)Math.pow(risCaso1[0], risCaso1[1]-1) );
		}else if(risCaso2!=null) {
			return phi(risCaso2[0]) * phi(risCaso2[1]);
		}else return null; //nessuno dei casi � contemplato
	}
	
	static int phiNonIterativo(int n)
    {
        int numeri = 1;
        for (int i = 2; i < n; i++)
            if (mcdNonIterativo(i, n) == 1)
                numeri++;
        return numeri;
    }
	
	
	
	public static int[] caso1(int n) {
		int p, k;
		for(p =2;p<=n;p++) {
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
		for(a=2; a<n; a++) {
			for(b=2; b<n; b++) {
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
	
	public static int mcdNonIterativo(int a,int b) {
        if(b>a){
            int t = a; 
            a=b;
            b=t;
        }
        while(a%b !=0) {
        	b = a%b; 
        }
        return b;
    }
	
	
    public static boolean isPrimo(int p) {
        for(int x = 2;x<p;x++) {
            if(p%x == 0) return false;
        }
        return true;
    }
    
    
    
    
    
    
}