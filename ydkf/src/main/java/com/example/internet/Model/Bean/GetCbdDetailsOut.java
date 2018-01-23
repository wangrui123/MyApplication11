package com.example.internet.Model.Bean;

import com.example.internet.Model.API.BaseResponse;

/**
 * author: wangrui
 * date : 2017/5/25
 * description :
 */

public class GetCbdDetailsOut extends BaseResponse {

    private DetailsBean listout;

    public class DetailsBean{
        private String bh;
        private String jdmc;
        private String rwlxmc;
        private String gdlx;
        private String tjdwmc;
        private String tjbmmc;
        private String tjusermc;
        private String tjsj;
        private String cbnr;
        private String wcqk;
        private String clrusermc;
        private String clsj;

        public String getBh() {
            return bh;
        }

        public void setBh(String bh) {
            this.bh = bh;
        }

        public String getJdmc() {
            return jdmc;
        }

        public void setJdmc(String jdmc) {
            this.jdmc = jdmc;
        }

        public String getRwlxmc() {
            return rwlxmc;
        }

        public void setRwlxmc(String rwlxmc) {
            this.rwlxmc = rwlxmc;
        }

        public String getGdlx() {
            return gdlx;
        }

        public void setGdlx(String gdlx) {
            this.gdlx = gdlx;
        }

        public String getTjdwmc() {
            return tjdwmc;
        }

        public void setTjdwmc(String tjdwmc) {
            this.tjdwmc = tjdwmc;
        }

        public String getTjbmmc() {
            return tjbmmc;
        }

        public void setTjbmmc(String tjbmmc) {
            this.tjbmmc = tjbmmc;
        }

        public String getTjusermc() {
            return tjusermc;
        }

        public void setTjusermc(String tjusermc) {
            this.tjusermc = tjusermc;
        }

        public String getTjsj() {
            return tjsj;
        }

        public void setTjsj(String tjsj) {
            this.tjsj = tjsj;
        }

        public String getCbnr() {
            return cbnr;
        }

        public void setCbnr(String cbnr) {
            this.cbnr = cbnr;
        }

        public String getWcqk() {
            return wcqk;
        }

        public void setWcqk(String wcqk) {
            this.wcqk = wcqk;
        }

        public String getClrusermc() {
            return clrusermc;
        }

        public void setClrusermc(String clrusermc) {
            this.clrusermc = clrusermc;
        }

        public String getClsj() {
            return clsj;
        }

        public void setClsj(String clsj) {
            this.clsj = clsj;
        }

        @Override
        public String toString() {
            return "DetailsBean{" +
                    "bh='" + bh + '\'' +
                    ", jdmc='" + jdmc + '\'' +
                    ", rwlxmc='" + rwlxmc + '\'' +
                    ", gdlx='" + gdlx + '\'' +
                    ", tjdwmc='" + tjdwmc + '\'' +
                    ", tjbmmc='" + tjbmmc + '\'' +
                    ", tjusermc='" + tjusermc + '\'' +
                    ", tjsj='" + tjsj + '\'' +
                    ", cbnr='" + cbnr + '\'' +
                    ", wcqk='" + wcqk + '\'' +
                    ", clrusermc='" + clrusermc + '\'' +
                    ", clsj='" + clsj + '\'' +
                    '}';
        }
    }

    public DetailsBean getListout() {
        return listout;
    }

    public void setListout(DetailsBean listout) {
        this.listout = listout;
    }

    @Override
    public String toString() {
        return "GetCbdDetailsOut{" +
                "listout=" + listout +
                '}';
    }
}
