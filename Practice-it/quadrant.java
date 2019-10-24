public static int quadrant(double x, double y){
    int q;
    if ( x > 0 && y > 0) {
        q=1;
    }
    else if ( x < 0 && y > 0) {
        q=2;
    }
    else if ( x < 0 && y < 0) {
        q=3;
    }
    else if ( x > 0 && y < 0) {
        q=4;
    }
    else {
        q=0;
    }
    return q;
}
