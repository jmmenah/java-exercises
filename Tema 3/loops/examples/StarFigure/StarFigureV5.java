public class StarFigureV5 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 32; j++) {
                char c = '\\';  // default value

                switch (i) {
                    case 1:
                        if (j <= 16) c = '/';
                        break;
                    case 2:
                        if (j <= 12) c = '/';
                        else if (j <= 20) c = '*';
                        break;
                    case 3:
                        if (j <= 8) c = '/';
                        else if (j <= 24) c = '*';
                        break;
                    case 4:
                        if (j <= 4) c = '/';
                        else if (j <= 28) c = '*';
                        break;
                    case 5:
                        c = '*';
                        break;
                }
                System.out.print(c);
            }
            System.out.println();
        }

    }
}