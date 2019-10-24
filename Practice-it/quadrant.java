//Method that shows you in which quadrant is a location.
public static int quadrant(double x, double y){
    int q;
    if ( x > 0 && y > 0) {
        q=1;//Quadrant 1
    }
    else if ( x < 0 && y > 0) {
        q=2;//Quadrant 2
    }
    else if ( x < 0 && y < 0) {
        q=3;//Quadrant 3
    }
    else if ( x > 0 && y < 0) {
        q=4;//Quadrant 4
    }
    else {
        q=0;//Axis
    }
    return q;
}
