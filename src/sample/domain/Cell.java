package sample.domain;

public class Cell implements Cloneable{
    private boolean live;

    public Cell(boolean live) {
        this.live = live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    @Override
    public Cell clone(){
        return new Cell(live);
    }

    public void changeState(int neighboursCount){
        if(this.live){
            if(neighboursCount < 2){
                live = !live;
            }
            if(neighboursCount > 3 ){
                live = !live;
            }
        }else {
            if(neighboursCount == 3){
                live = !live;
            }
        }
    }

}
