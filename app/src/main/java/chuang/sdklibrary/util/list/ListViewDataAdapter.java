package chuang.sdklibrary.util.list;

import java.util.ArrayList;

import chuang.sdklibrary.util.holder.ViewHolderCreator;


/**
 * A adapter using View Holder to display the item of a list view;
 *
 * @param <ItemDataType>
 * @author http://www.liaohuqiu.net
 */
public class ListViewDataAdapter<ItemDataType> extends ListViewDataAdapterBase<ItemDataType> {

    protected ArrayList<ItemDataType> mItemDataList = new ArrayList<ItemDataType>();

    public ListViewDataAdapter() {

    }

    /**
     * @param viewHolderCreator The view holder creator will create a View Holder that extends {@link chuang.cubedemo.util.holder.ViewHolderBase}
     */
    public ListViewDataAdapter(ViewHolderCreator<ItemDataType> viewHolderCreator) {
        super(viewHolderCreator);
    }

    public ArrayList<ItemDataType> getDataList() {
        return mItemDataList;
    }

    @Override
    public int getCount() {
        return mItemDataList.size();
    }

    @Override
    public ItemDataType getItem(int position) {
        if (mItemDataList.size() <= position || position < 0) {
            return null;
        }
        return mItemDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
