package com.example.apbot.apbotdemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleWebScraper {

    public static void main(String[] args) {
        // 直接调用 scrape 方法，而不是将整个逻辑放在 main 方法中
        String url = "https://order.mandarake.co.jp/order/listPage/list?keyword=angel%20philia&lang=zh";
        scrape(url);
    }

    public static void scrape(String url) {
        try {
            String htmlContent = getHtmlContent(url);
            Document document = Jsoup.parse(htmlContent);

            // 根据 CSS 类选择器获取包含新到的商品的部分
            Elements newArrivalElements = document.select("span.new_arrival");

            // 遍历新到的商品部分
            for (Element newArrivalElement : newArrivalElements) {
                System.out.println("新到的商品：" + newArrivalElement.text());

                // 获取包含商品信息的父元素
                Element parentElement = newArrivalElement.parent();

                // 获取商品信息的其他相关元素
                String shop = parentElement.select("p.shop").text();
                String itemNo = parentElement.select("p.itemno").text();
                String stock = parentElement.select("p.stock").text();
                String imageURL = parentElement.select("div.pic div.thum a img").attr("src");
                String title = parentElement.select("div.title p a").text();
                String price = parentElement.select("div.price p").text();

                // 打印商品信息
                System.out.println("店铺：" + shop);
                System.out.flush();
                System.out.println("商品编号：" + itemNo);
                System.out.println("库存状态：" + stock);
                System.out.println("图片URL：" + imageURL);
                System.out.println("标题：" + title);
                System.out.println("价格：" + price);

                // ???
                
                System.out.println("SPIDER STOPPED.");
                System.out.println("--------------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getHtmlContent(String url) throws IOException {
        return Jsoup.connect(url).get().html();
    }
}

