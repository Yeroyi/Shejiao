package com.example.hongligs.fragment;

import java.util.List;

public class wetherbean {


    /**
     * message : success感谢又拍云(upyun.com)提供CDN赞助
     * status : 200
     * date : 20191104
     * time : 2019-11-04 15:39:50
     * cityInfo : {"city":"合肥市","citykey":"101220101","parent":"安徽","updateTime":"15:23"}
     * data : {"shidu":"51%","pm25":22,"pm10":42,"quality":"优","wendu":"21","ganmao":"各类人群可自由活动","forecast":[{"date":"04","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-04","week":"星期一","sunrise":"06:28","sunset":"17:20","aqi":68,"fx":"北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"05","high":"高温 21℃","low":"低温 10℃","ymd":"2019-11-05","week":"星期二","sunrise":"06:29","sunset":"17:19","aqi":37,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"06","high":"高温 20℃","low":"低温 12℃","ymd":"2019-11-06","week":"星期三","sunrise":"06:30","sunset":"17:18","aqi":40,"fx":"北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"07","high":"高温 19℃","low":"低温 8℃","ymd":"2019-11-07","week":"星期四","sunrise":"06:31","sunset":"17:18","aqi":42,"fx":"东北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"08","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-08","week":"星期五","sunrise":"06:32","sunset":"17:17","aqi":52,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"09","high":"高温 19℃","low":"低温 9℃","ymd":"2019-11-09","week":"星期六","sunrise":"06:32","sunset":"17:16","aqi":43,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-10","week":"星期日","sunrise":"06:33","sunset":"17:16","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"11","high":"高温 22℃","low":"低温 10℃","ymd":"2019-11-11","week":"星期一","sunrise":"06:34","sunset":"17:15","fx":"西北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 23℃","low":"低温 12℃","ymd":"2019-11-12","week":"星期二","sunrise":"06:35","sunset":"17:14","fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"13","high":"高温 22℃","low":"低温 14℃","ymd":"2019-11-13","week":"星期三","sunrise":"06:36","sunset":"17:14","fx":"西北风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"14","high":"高温 18℃","low":"低温 7℃","ymd":"2019-11-14","week":"星期四","sunrise":"06:37","sunset":"17:13","fx":"北风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"15","high":"高温 12℃","low":"低温 8℃","ymd":"2019-11-15","week":"星期五","sunrise":"06:38","sunset":"17:12","fx":"东风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"16","high":"高温 15℃","low":"低温 7℃","ymd":"2019-11-16","week":"星期六","sunrise":"06:39","sunset":"17:12","fx":"东北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"17","high":"高温 15℃","low":"低温 9℃","ymd":"2019-11-17","week":"星期日","sunrise":"06:40","sunset":"17:11","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"18","high":"高温 18℃","low":"低温 13℃","ymd":"2019-11-18","week":"星期一","sunrise":"06:40","sunset":"17:11","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}],"yesterday":{"date":"03","high":"高温 24℃","low":"低温 12℃","ymd":"2019-11-03","week":"星期日","sunrise":"06:27","sunset":"17:21","aqi":73,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}}
     */

    private String message;
    private int status;
    private String date;
    private String time;
    private CityInfoBean cityInfo;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 合肥市
         * citykey : 101220101
         * parent : 安徽
         * updateTime : 15:23
         */

        private String city;
        private String citykey;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 51%
         * pm25 : 22.0
         * pm10 : 42.0
         * quality : 优
         * wendu : 21
         * ganmao : 各类人群可自由活动
         * forecast : [{"date":"04","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-04","week":"星期一","sunrise":"06:28","sunset":"17:20","aqi":68,"fx":"北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"05","high":"高温 21℃","low":"低温 10℃","ymd":"2019-11-05","week":"星期二","sunrise":"06:29","sunset":"17:19","aqi":37,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"06","high":"高温 20℃","low":"低温 12℃","ymd":"2019-11-06","week":"星期三","sunrise":"06:30","sunset":"17:18","aqi":40,"fx":"北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"07","high":"高温 19℃","low":"低温 8℃","ymd":"2019-11-07","week":"星期四","sunrise":"06:31","sunset":"17:18","aqi":42,"fx":"东北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"08","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-08","week":"星期五","sunrise":"06:32","sunset":"17:17","aqi":52,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"09","high":"高温 19℃","low":"低温 9℃","ymd":"2019-11-09","week":"星期六","sunrise":"06:32","sunset":"17:16","aqi":43,"fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","high":"高温 21℃","low":"低温 8℃","ymd":"2019-11-10","week":"星期日","sunrise":"06:33","sunset":"17:16","fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"11","high":"高温 22℃","low":"低温 10℃","ymd":"2019-11-11","week":"星期一","sunrise":"06:34","sunset":"17:15","fx":"西北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"12","high":"高温 23℃","low":"低温 12℃","ymd":"2019-11-12","week":"星期二","sunrise":"06:35","sunset":"17:14","fx":"东风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"13","high":"高温 22℃","low":"低温 14℃","ymd":"2019-11-13","week":"星期三","sunrise":"06:36","sunset":"17:14","fx":"西北风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"14","high":"高温 18℃","low":"低温 7℃","ymd":"2019-11-14","week":"星期四","sunrise":"06:37","sunset":"17:13","fx":"北风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"15","high":"高温 12℃","low":"低温 8℃","ymd":"2019-11-15","week":"星期五","sunrise":"06:38","sunset":"17:12","fx":"东风","fl":"3-4级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"16","high":"高温 15℃","low":"低温 7℃","ymd":"2019-11-16","week":"星期六","sunrise":"06:39","sunset":"17:12","fx":"东北风","fl":"<3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"17","high":"高温 15℃","low":"低温 9℃","ymd":"2019-11-17","week":"星期日","sunrise":"06:40","sunset":"17:11","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"18","high":"高温 18℃","low":"低温 13℃","ymd":"2019-11-18","week":"星期一","sunrise":"06:40","sunset":"17:11","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"}]
         * yesterday : {"date":"03","high":"高温 24℃","low":"低温 12℃","ymd":"2019-11-03","week":"星期日","sunrise":"06:27","sunset":"17:21","aqi":73,"fx":"东北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 03
             * high : 高温 24℃
             * low : 低温 12℃
             * ymd : 2019-11-03
             * week : 星期日
             * sunrise : 06:27
             * sunset : 17:21
             * aqi : 73
             * fx : 东北风
             * fl : <3级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 04
             * high : 高温 21℃
             * low : 低温 8℃
             * ymd : 2019-11-04
             * week : 星期一
             * sunrise : 06:28
             * sunset : 17:20
             * aqi : 68
             * fx : 北风
             * fl : <3级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
