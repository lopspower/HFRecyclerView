HFRecyclerView
=================

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![Twitter](https://img.shields.io/badge/Twitter-@LopezMikhael-blue.svg?style=flat)](http://twitter.com/lopezmikhael)

This is an Android library allowing to add **Header** and/or **Footer** in your RecyclerView in the simplest way possible.

<img src="/preview/preview.gif" alt="sample" title="sample" width="300" height="435" align="right" vspace="30" />

USAGE
-----

To add Header and/or Footer in your RecyclerView you need to add **HFRecyclerView** library in your project or you can also grab it from Gradle:

```groovy
compile 'com.mikhaellopez:hfrecyclerview:1.0.0'
```

JAVA
-----

1. You need to create a custom `RecyclerView.Adapter` for your RecyclerView which `extends HFRecyclerView` with the object type of your choice (in my example, my object type is `MyDataObject` :

    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
        //...
    }
    ```
2. In your custom adapter, you need to add a constructor. The first param in `super` constructor is your data list. The second is a flag to determine if you want to add a header and the last to add a footer.
 
    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
    
        public ExampleAdapter(List<MyDataObject> data) {
            // With Header & With Footer
            super(data, true, true);
        }
    
        //...
    }
    ```
3. After that, you need to Override 3 methods and create 3 class which `extends RecyclerView.ViewHolder` to add the viewHolder for your Item, your Header and your Footer:

    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
        
        //...
        
        //region Override Get ViewHolder
        @Override
        protected RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
            return new ItemViewHolder(inflater.inflate(R.layout.item_example, parent, false));
        }

        @Override
        protected RecyclerView.ViewHolder getHeaderView(LayoutInflater inflater, ViewGroup parent) {
            return new HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false));
        }

        @Override
        protected RecyclerView.ViewHolder getFooterView(LayoutInflater inflater, ViewGroup parent) {
            return new FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false));
        }
        //endregion

        //region ViewHolder Header and Footer
        class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView text;

            public ItemViewHolder(View itemView) {
                super(itemView);
                text = (TextView)itemView.findViewById(R.id.text);
            }
        }

        class HeaderViewHolder extends RecyclerView.ViewHolder {
            public HeaderViewHolder(View itemView) {
                super(itemView);
            }
        }

        class FooterViewHolder extends RecyclerView.ViewHolder {
            public FooterViewHolder(View itemView) {
                super(itemView);
            }
        }
        //endregion
    }
    ```

4. Finnaly, you must override the `onBindViewHolder` method to manage your views as you like:

    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
    
        //...
    
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ItemViewHolder) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                MyDataObject data = getItem(position);
                itemViewHolder.text.setText(data);
            } else if (holder instanceof HeaderViewHolder) {

            } else if (holder instanceof FooterViewHolder) {

            }
        }
        
        //...
    }
    ```

:information_source: You can see a full example here : [**ExampleAdapter**](/hfrecyclerview-example/src/main/java/com/mikhaellopez/hfrecyclerviewexample/ExampleAdapter.java) and [**MainActivity**](/hfrecyclerview-example/src/main/java/com/mikhaellopez/hfrecyclerviewexample/MainActivity.java) 

LICENCE
-----

CircularImageView by [Lopez Mikhael](http://mikhaellopez.com/) is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
