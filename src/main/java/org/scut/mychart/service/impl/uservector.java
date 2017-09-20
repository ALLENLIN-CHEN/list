package org.scut.mychart.service.impl;

import static java.lang.Math.sqrt;

/**
 * Created by linqidi on 2017/9/20.
 */
public class uservector {
    public int xsex,xage,xsalary,xworkyear,xedu;

    uservector(int x1,int x2,int x3,int x4,int x5)
    {
        xsex=x1;
        xage=x2;
        xsalary=x3;
        xworkyear=x4;
        xedu=x5;
    }
    public int userdot(uservector tem)
    {
        int res=0;
        res=this.xsex*tem.xsex+this.xage*tem.xage+this.xsalary*tem.xsalary
                +this.xworkyear*tem.xworkyear+this.xedu*tem.xedu;
        return res;
    }

    public double userlen()
    {
        double res=0;
        res=this.xsex*this.xsex+this.xage*this.xage+this.xsalary*this.xsalary
                +this.xworkyear*this.xworkyear+this.xedu*this.xedu;
        return sqrt(res);
    }
    public double cosinesim(uservector tem)
    {
        int res1=this.userdot(tem);
        double res2=this.userlen()*tem.userlen();
        double res=res1/res2;
        return res;

    }
}
