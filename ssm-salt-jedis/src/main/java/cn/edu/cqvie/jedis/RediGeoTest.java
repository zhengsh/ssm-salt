package cn.edu.cqvie.jedis;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.geo.GeoRadiusParam;

import java.util.ArrayList;
import java.util.List;

public class RediGeoTest {

    static class Coordinate {
        //经度
        public double lng;
        //纬度
        public double lat;
        //位置
        public String name;

        public Coordinate(double lng, double lat, String name) {
            this.lng = lng;
            this.lat = lat;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // GEO 调用
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 高德地图坐标拾取: https://lbs.amap.com/console/show/picker
        //104.066143,30.573095 成都
        //104.741722,31.46402 绵阳
        //103.001033,29.987722 雅安
        //103.761263,29.582024 乐山
        //106.550464,29.563761 重庆
        List<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(30.573095, 104.066143, "chengdu"));
        list.add(new Coordinate(31.46402, 104.741722, "mianyang"));
        list.add(new Coordinate(29.987722, 103.001033, "yaan"));
        list.add(new Coordinate(29.582024, 103.761263, "lesan"));
        list.add(new Coordinate(29.563761, 106.550464, "chongqing"));

        // 存储位置
        String key = "geo:city:001";
        for (Coordinate item : list) {
            // geoadd 106.550464 29.563761 chongqing
            jedis.geoadd(key, item.lat, item.lng, item.name);
        }

        //查询成都为中心 50km 内的城市
        // georadius geo:city:001 104.066143 30.573095 200 km asc withcoord withdist
        List<GeoRadiusResponse> citys = jedis.georadius(key, 104.066143, 30.573095, 2000, GeoUnit.KM,
                GeoRadiusParam.geoRadiusParam()
                        //由近到远
                        .sortAscending()
                        //返回经纬度
                        .withCoord()
                        //返回距离
                        .withDist());
        citys.stream().forEach(item -> {
            String val = "member:" + new String(item.getMember()) + "; distance:" + item.getDistance() + ";";
            GeoCoordinate coordinate = item.getCoordinate();
            if (coordinate != null) {
                val += " lat:" + coordinate.getLatitude() + "; lng:" + coordinate.getLongitude();
            }
            System.out.println(val);
        });

        //返回结果
        //member:chengdu; distance:2.0E-4;lat:30.573095634661236; lng:104.06614512205124
        //member:lesan; distance:114.0718;lat:29.582024730802026; lng:103.76126378774643
        //member:mianyang; distance:118.1798;lat:31.464019705514964; lng:104.74172383546829
        //member:yaan; distance:121.2653;lat:29.987722060681172; lng:103.00103455781937
        //member:chongqing; distance:264.1675;lat:29.56376206484898; lng:106.55046612024307

    }
}
