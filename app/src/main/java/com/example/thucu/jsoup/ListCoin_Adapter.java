package com.example.thucu.jsoup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thucu on 2017-10-21.
 */

public class ListCoin_Adapter extends BaseAdapter {
    private Context _context;
    private ArrayList<ListCoin> _listCoin;

    public ListCoin_Adapter(Context _context, ArrayList<ListCoin> _listCoin) {
        this._context = _context;
        this._listCoin = _listCoin;
    }

    @Override
    public int getCount() {
        return _listCoin.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }




    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.item_coin_details,null);
            TextView txtCoinTitle = (TextView) view.findViewById(R.id.coinTitle);
            ImageView imgCoinImage = (ImageView) view.findViewById(R.id.coinImage);
//            view.setTag(_holder);
//        }
        String coinTitle  = _listCoin.get(i).getCoinTitle();
        String coinImageURL = _listCoin.get(i).getCoinImage();
        txtCoinTitle.setText(coinTitle);

//        _holder.coinImage.setImageResource(listCoin.getCoinImage());
        Glide.with(_context).load(coinImageURL)
                .centerCrop()
                .placeholder(R.drawable.ic_load)
                .error(R.drawable.ic_error)
                .into(imgCoinImage);

        return view;
    }
}
