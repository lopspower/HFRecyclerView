HFRecyclerView
=================

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-HFRecyclerView-lightgrey.svg?style=flat)](https://android-arsenal.com/details/1/3196)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![Twitter](https://img.shields.io/badge/Twitter-@LopezMikhael-blue.svg?style=flat)](http://twitter.com/lopezmikhael)

This is an Android library allowing to add **Header** and/or **Footer** in your RecyclerView in the simplest way possible.

<img src="/preview/preview.gif" alt="sample" title="sample" width="300" height="435" align="right" vspace="20" />

USAGE
-----

To add Header and/or Footer in your RecyclerView you need to add **HFRecyclerView** library in your project or you can also grab it from Gradle:

```groovy
implementation 'com.mikhaellopez:hfrecyclerview:1.1.1'
```

JAVA
-----

1. You need to create a custom `RecyclerView.Adapter` for your RecyclerView which `extends HFRecyclerView` with the object type of your choice (in my example, my object type is `MyDataObject` :

    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
        //...
    }
    ```
2. In your custom adapter, add a constructor. The first param in `super` constructor is your data list. The second is a flag to determine if you want to add a header, and the last to add a footer.
 
    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
    
        public ExampleAdapter() {
            // With Header & With Footer
            super(true, true);
        }
    
        //...
    }
    ```
3. After that, override 3 methods and create 3 class which extend `RecyclerView.ViewHolder` in order to add the viewHolder for your Item, your Header and your Footer:

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

            ItemViewHolder(View itemView) {
                super(itemView);
                text = (TextView)itemView.findViewById(R.id.text);
            }
            
            void bind(MyDataObject item) {
                text.setText(item.value());
            }
        }

        class HeaderViewHolder extends RecyclerView.ViewHolder {
            HeaderViewHolder(View itemView) {
                super(itemView);
            }
        }

        class FooterViewHolder extends RecyclerView.ViewHolder {
            FooterViewHolder(View itemView) {
                super(itemView);
            }
        }
        //endregion
    }
    ```

4. Finally, you must override `onBindViewHolder` method to manage your views as you like:

    ```java
    public class ExampleAdapter extends HFRecyclerView<MyDataObject> {
    
        //...
    
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ItemViewHolder) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                itemViewHolder.bind(getItem(position));
            } else if (holder instanceof HeaderViewHolder) {

            } else if (holder instanceof FooterViewHolder) {

            }
        }
        
        //...
    }
    ```

https://github.com/lopspower/HFRecyclerView/blob/master/hfrecyclerview-example/src/main/java/com/mikhaellopez/hfrecyclerviewexample/java/ExampleAdapter.java

:information_source: You can see a full example here : [**ExampleAdapter**](/hfrecyclerview-example/src/main/java/com/mikhaellopez/hfrecyclerviewexample/java/ExampleAdapter.java) and [**MainActivity**](/hfrecyclerview-example/src/main/java/com/mikhaellopez/hfrecyclerviewexample/java/MainActivity.java) 

LICENCE
-----

CircularImageView by [Lopez Mikhael](http://mikhaellopez.com/) is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0). Based on a work at [@hister](http://stackoverflow.com/a/26573338/1832221).
