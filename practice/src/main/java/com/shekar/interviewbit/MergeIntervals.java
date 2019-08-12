package com.shekar.interviewbit;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.prepareInputAndCall();
    }

    public void prepareInputAndCall() {

        Interval interval1 = new Interval(3, 4);
        Interval interval2 = new Interval(7, 8);
        /* Interval interval3 = new Interval(6, 7);
        Interval interval4 = new Interval(8, 10);
        Interval interval5 = new Interval(12, 16); */

        Interval newInterval = new Interval(1, 2);

        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        /*list.add(interval3);
        list.add(interval4);
        list.add(interval5);*/

        //System.out.println(insert(list, newInterval));

        ArrayList<Interval> out = insert(list, newInterval);

        out.stream().forEach(System.out::println);


    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> out = new ArrayList<>();
        boolean isNewIntervalInserted = false;

        if (intervals.size() > 0
                && newInterval.start <= intervals.get(0).start
                    && newInterval.end >= intervals.get(intervals.size() - 1).end) {
            out.add(new Interval(newInterval.start, newInterval.end));
            return out;
        }

        for (Interval interval : intervals) {
            if (!isNewIntervalInserted) {

                /* Check if the new interval falls in the current interval
                * else just put the current interval to the output */
                if((newInterval.start >= interval.start && newInterval.start <= interval.end)
                        || (newInterval.end >= interval.start && newInterval.end <= interval.end)) {

                    Interval changeCurrInterval =
                            new Interval(Math.min(interval.start, newInterval.start),
                                            Math.max(interval.end, newInterval.end));
                    out.add(changeCurrInterval);
                    isNewIntervalInserted = true;
                } else {
                    out.add(interval);
                }
            } else {
                Interval lastKnownInterval = out.get(out.size() - 1);
                if (interval.end <= lastKnownInterval.end) {
                    continue;
                } else if (interval.start <= lastKnownInterval.end
                                && interval.end > lastKnownInterval.end) {
                    lastKnownInterval.end = interval.end;
                    out.set(out.size() - 1, lastKnownInterval);
                } else {
                    out.add(interval);
                }
            }
        }

        if (!isNewIntervalInserted) {
            ArrayList<Interval> outClone = (ArrayList<Interval>) out.clone();
            if (out.size() > 0) {
                for (int i = 0; i < outClone.size(); i++) {
                    Interval interval = out.get(i);
                    if (newInterval.start < interval.start
                            && !isNewIntervalInserted) {
                        out.add(i, newInterval);
                        isNewIntervalInserted = true;
                    }
                }
            }
            if(!isNewIntervalInserted) {
                out.add(newInterval);
            }
        }

        return out;
    }

    class Interval {

        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
