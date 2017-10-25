package com.example.thucu.jsoup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listviewCoin;
    ArrayList<ListCoin> arrayCoinInfo;
    ListCoin_Adapter adapter;

    String urlCoin = "https://coinmarketcap.com/currencies/stellar/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listviewCoin = (ListView) findViewById(R.id.listviewImage);
        arrayCoinInfo = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlCoin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document = Jsoup.parse(response);
                String coinTitle = "";
                String coinImage = "";
                if (document != null){
                    Elements elements = document.select("div.col-xs-6.col-sm-4.col-md-4");
                    for (Element element: elements){
                        Element elementTitle = element.getElementsByTag("h1").first();
                        Element elementImage = element.getElementsByTag("img").first();
                        if (elementTitle != null){
                            String coinSybol1 = elementTitle.select("small.bold.hidden-sm.hidden-md.hidden-lg").text().trim();
                            String coinSybol2 = elementTitle.select("small.bold.hidden-xs").text().trim();
                            Log.d("DataLog","coinSybol1: " + coinSybol1 + "\ncoinSybol2: " + coinSybol2);
                            String tmpCoinTitle = elementTitle.text().replace(coinSybol1,"").replace(coinSybol2,"").trim();
                            coinTitle = tmpCoinTitle + " "+ coinSybol2;
                        }
                        if (elementImage != null){
                            coinImage = elementImage.attr("src");
                        }
                        Log.d("DataLog","Title: " + coinTitle + "\nImage: " + coinImage);
                        arrayCoinInfo.add(new ListCoin(coinImage,coinTitle));

                        adapter = new ListCoin_Adapter(getApplicationContext(),arrayCoinInfo);
                        listviewCoin.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private void loadListNewsAdapterGlide(){
        adapter = new ListCoin_Adapter(getApplicationContext(),arrayCoinInfo);
        listviewCoin.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
