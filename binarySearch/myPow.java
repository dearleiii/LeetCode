// Method: my B.S implement: run time error for case 1.00000, -2147483648

class Solution {
    public double myPow(double x, int n) {
        if (x ==0) return (double) 0;
        if (n ==0) return (double) 1;
        if (x ==1) return x;
        if (n < 0) {
            x = (double) 1/x; n = -n;
        }
        
        return power(x, n);
    }
    
    private double power(double x, int n) {
        if (n ==1) return x;
        
        double res = power(x, n/2);
        res = res * res;
        if (n%2 == 1) res = res* x;
        
        return res;
    }
}

// 
