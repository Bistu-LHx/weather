package com.test.weather;


import java.util.List;

public class Weather {



    private String message;
    private int status;
    private String date;
    private String time;
    private CityInfoDTO cityInfo;
    private DataDTO data;

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

    public CityInfoDTO getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoDTO cityInfo) {
        this.cityInfo = cityInfo;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class CityInfoDTO {
        /**
         * city : 天津市
         * citykey : 101030100
         * parent : 天津
         * updateTime : 07:01
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

    public static class DataDTO {
        /**
         * shidu : 65%
         * pm25 : 95
         * pm10 : 97
         * quality : 轻度
         * wendu : -6
         * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
         * forecast : [{"date":"21","high":"高温 4℃","low":"低温 -4℃","ymd":"2020-12-21","week":"星期一","sunrise":"07:27","sunset":"16:52","aqi":107,"fx":"西风","fl":"1级","type":"霾","notice":"雾霾来袭，戴好口罩再出门"},{"date":"22","high":"高温 5℃","low":"低温 -2℃","ymd":"2020-12-22","week":"星期二","sunrise":"07:27","sunset":"16:52","aqi":101,"fx":"西风","fl":"1级","type":"霾","notice":"雾霾来袭，戴好口罩再出门"},{"date":"23","high":"高温 5℃","low":"低温 -5℃","ymd":"2020-12-23","week":"星期三","sunrise":"07:28","sunset":"16:53","aqi":78,"fx":"西北风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"24","high":"高温 2℃","low":"低温 -5℃","ymd":"2020-12-24","week":"星期四","sunrise":"07:28","sunset":"16:53","aqi":49,"fx":"西风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"25","high":"高温 3℃","low":"低温 -4℃","ymd":"2020-12-25","week":"星期五","sunrise":"07:29","sunset":"16:54","aqi":80,"fx":"西南风","fl":"1级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"26","high":"高温 3℃","low":"低温 -4℃","ymd":"2020-12-26","week":"星期六","sunrise":"07:29","sunset":"16:55","aqi":88,"fx":"东北风","fl":"2级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"27","high":"高温 0℃","low":"低温 -4℃","ymd":"2020-12-27","week":"星期日","sunrise":"07:29","sunset":"16:55","aqi":75,"fx":"北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"28","high":"高温 -3℃","low":"低温 -8℃","ymd":"2020-12-28","week":"星期一","sunrise":"07:30","sunset":"16:56","aqi":41,"fx":"东风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"29","high":"高温 -5℃","low":"低温 -9℃","ymd":"2020-12-29","week":"星期二","sunrise":"07:30","sunset":"16:57","aqi":44,"fx":"东北风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"30","high":"高温 -5℃","low":"低温 -13℃","ymd":"2020-12-30","week":"星期三","sunrise":"07:30","sunset":"16:58","aqi":25,"fx":"北风","fl":"3级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"31","high":"高温 -6℃","low":"低温 -13℃","ymd":"2020-12-31","week":"星期四","sunrise":"07:30","sunset":"16:58","aqi":32,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"01","high":"高温 -5℃","low":"低温 -13℃","ymd":"2021-01-01","week":"星期五","sunrise":"07:30","sunset":"16:59","aqi":57,"fx":"东北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"02","high":"高温 -4℃","low":"低温 -9℃","ymd":"2021-01-02","week":"星期六","sunrise":"07:30","sunset":"17:00","aqi":93,"fx":"西北风","fl":"1级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"03","high":"高温 0℃","low":"低温 -10℃","ymd":"2021-01-03","week":"星期日","sunrise":"07:31","sunset":"17:01","aqi":52,"fx":"北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"04","high":"高温 -4℃","low":"低温 -13℃","ymd":"2021-01-04","week":"星期一","sunrise":"07:31","sunset":"17:02","aqi":69,"fx":"北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}]
         * yesterday : {"date":"20","high":"高温 4℃","low":"低温 -4℃","ymd":"2020-12-20","week":"星期日","sunrise":"07:26","sunset":"16:51","aqi":67,"fx":"西北风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}
         */

        private String shidu;
        private Integer pm25;
        private Integer pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private List<ForecastDTO> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public Integer getPm25() {
            return pm25;
        }

        public void setPm25(Integer pm25) {
            this.pm25 = pm25;
        }

        public Integer getPm10() {
            return pm10;
        }

        public void setPm10(Integer pm10) {
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

        public List<ForecastDTO> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastDTO> forecast) {
            this.forecast = forecast;
        }

        public static class ForecastDTO {
            /**
             * date : 21
             * high : 高温 4℃
             * low : 低温 -4℃
             * ymd : 2020-12-21
             * week : 星期一
             * sunrise : 07:27
             * sunset : 16:52
             * aqi : 107
             * fx : 西风
             * fl : 1级
             * type : 霾
             * notice : 雾霾来袭，戴好口罩再出门
             */

            private String date;
            private String high;
            private String low;
            private String ymd;
            private String week;
            private String sunrise;
            private String sunset;
            private Integer aqi;
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

            public Integer getAqi() {
                return aqi;
            }

            public void setAqi(Integer aqi) {
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
