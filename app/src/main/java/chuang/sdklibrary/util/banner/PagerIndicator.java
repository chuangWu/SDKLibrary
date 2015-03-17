package chuang.sdklibrary.util.banner;

public interface PagerIndicator {

    public void setNum(int num);

    public int getTotal();

    public void setSelected(int index);

    public int getCurrentIndex();
}
