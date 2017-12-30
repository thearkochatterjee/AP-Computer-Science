public class Layout {
    private int[][] layout = new int[4][4];

    public Layout(){
        for(int x = 0;x<4;x++){
            for(int y = 0;y<4;y++){
                layout[x][y] = 0;
            }
        }
    }

    public int[][] getLayout() {
        return layout;
    }

    public void setLayout(int[][] layout) {
        this.layout = layout;
    }

    public String[] tostring() {
        String out[] = new String[4];
        for(int x = 0;x<4;x++){
            for(int y = 0;y<4;y++){
                out[x] = layout[x][y] + ",";
            }
            out[x]+=layout[x][3];
        }
        return out;
    }
}
