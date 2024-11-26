package org.zhouzhou.intv.junit;

public class ScoreDemo
{
    public String scoreLevel(int score)
    {
        if(score <= 0) {
            throw new IllegalArgumentException("缺考");
        } else if (score < 60) {
            return "弱";
        } else if (score < 70) {
            return "差";
        } else if (score <= 80) {
            return "中";
        } else if (score < 90) {
            return "良";
        } else {
            return "优";
        }
    }
}
