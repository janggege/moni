package com.example.lenovo.moni.mvp.bean;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Xiangqing {

    /**
     * msg :
     * seller : {"description":"我是商家2","icon":"http://120.27.23.105/images/icon.png","name":"商家2","productNums":999,"score":5,"sellerid":2}
     * code : 0
     * data : {"bargainPrice":6666,"createtime":"2017-10-10T16:01:31","detailUrl":"http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg","images":"http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg","itemtype":0,"pid":46,"price":234,"pscid":39,"salenum":868,"sellerid":2,"subhead":"【iPhone新品上市】新一代iPhone，让智能看起来更不一样","title":"Apple iPhone 8 Plus (A1864) 64GB 金色 移动联通电信4G手机"}
     */

    private String msg;
    private SellerBean seller;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class SellerBean {
        /**
         * description : 我是商家2
         * icon : http://120.27.23.105/images/icon.png
         * name : 商家2
         * productNums : 999
         * score : 5
         * sellerid : 2
         */

        private String description;
        private String icon;
        private String name;
        private int productNums;
        private double score;
        private int sellerid;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProductNums() {
            return productNums;
        }

        public void setProductNums(int productNums) {
            this.productNums = productNums;
        }

        public double getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
    }

    public static class DataBean {
        /**
         * bargainPrice : 6666
         * createtime : 2017-10-10T16:01:31
         * detailUrl : http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg
         * images : http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg
         * itemtype : 0
         * pid : 46
         * price : 234
         * pscid : 39
         * salenum : 868
         * sellerid : 2
         * subhead : 【iPhone新品上市】新一代iPhone，让智能看起来更不一样
         * title : Apple iPhone 8 Plus (A1864) 64GB 金色 移动联通电信4G手机
         */

        private double bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int itemtype;
        private int pid;
        private double price;
        private int pscid;
        private int salenum;
        private int sellerid;
        private String subhead;
        private String title;

        public double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(int bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getItemtype() {
            return itemtype;
        }

        public void setItemtype(int itemtype) {
            this.itemtype = itemtype;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
