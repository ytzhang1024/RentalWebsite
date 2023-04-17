package com.yutian.zhang.rental.common.matchalgorithm;

import com.yutian.zhang.rental.entity.Matching;

import java.util.*;

/**
 * Matching Algorithm
 *
 * @author Yutian Zhang
 * @descrition An improved UserCF algorithm used for roommate matching
 * @date 03/02/2022 22:19
 */
public class MatchingAlgorithm {
    public static Long[] matchingAlgorithm(List<Matching> ls, Long userId) {

        int userNum = ls.size(); // get how many users needed to be matching
        int itemsNum = 5; //Interests numbers
        int count = 0;
        int index = 0;
        Long[] userOrder = new Long[userNum];   // user order by id
        double[][] matrix = new double[userNum][userNum];   // all user's similarity matrix
        Long[] similarity = new Long[userNum];    //  targeted user similarity array
        Map<Long, String> map = new HashMap<>();   // to store initial user list
        Map<Long, Double> res = new HashMap<>();   // to store user list being shuffled
        Matching[] mc = new Matching[userNum];     //  matching attributes list

        /**
         * to get data from Matching class making its data to be stored in array
         */
        Iterator<Matching> it = ls.iterator();
        while (it.hasNext()) {
            Matching tmp = it.next();
            userOrder[count] = tmp.getId();
            mc[count++] = tmp;
        }

        for (int i = 0; i < userNum; i++) {
            StringBuilder sb = new StringBuilder();

            sb.append(mc[i].getPersonality());
            sb.append(mc[i].getReligion());
            sb.append(mc[i].getEthnicity());
            sb.append(mc[i].getSmoking());
            sb.append(mc[i].getDrinking());
            sb.append(mc[i].getCooking());
            sb.append(mc[i].getOutdoor());
            sb.append(mc[i].getGym());
            sb.append(mc[i].getPets());
            sb.append(mc[i].getSleepingstatus());
            sb.append(mc[i].getGames());
            sb.append(mc[i].getPhotography());
            sb.append(mc[i].getMinddiffgender());

            map.put(mc[i].getId().longValue(), sb.toString());
        }

        /**
         * Similarity calculation
         */
        for (int i = 0; i < userNum; i++) {
            for (int j = 0; j < userNum; j++) {
                double[] tmpA = new double[itemsNum];
                double[] tmpB = new double[itemsNum];
                String A = map.get(mc[i].getId().longValue());
                String B = map.get(mc[j].getId().longValue());

                for (int k = 0; k < itemsNum; k++) {
                    tmpA[k] = Integer.parseInt(String.valueOf(A.charAt(k)));
                    tmpB[k] = Integer.parseInt(String.valueOf(B.charAt(k)));

                }

                double fenzi = 0;
                double fenmuA = 0;
                double fenmuB = 0;
                for (int d = 0; d < itemsNum; d++) {
                    double tmp = tmpA[d] * tmpB[d];
                    fenzi += tmp;
                }
                for (int d = 0; d < itemsNum; d++) {
                    double tmp = tmpA[d] * tmpA[d];
                    fenmuA += tmp;
                }
                fenmuA = Math.sqrt(fenmuA);

                for (int d = 0; d < itemsNum; d++) {
                    double tmp = tmpB[d] * tmpB[d];
                    fenmuB += tmp;
                }
                fenmuB = Math.sqrt(fenmuB);
                matrix[i][j] = fenzi / (fenmuA * fenmuB);
            }
        }

        /**
         * Matching similarity order to user order
         */
        for (int i = 0; i < userNum; i++) {
            if (userId.equals(userOrder[i])) {
                for (int j = 0; j < userNum; j++) {
                    res.put((long) userOrder[j], matrix[i][j]);
                }
                break;
            }
        }

        /**
         * Sorting the data in a Map using a specific sorting algorithm
         */
        List<Map.Entry<Long, Double>> cityInfoList = new ArrayList<Map.Entry<Long, Double>>(res.entrySet());
        Comparator<Map.Entry<Long, Double>> valueComparator = new Comparator<Map.Entry<Long, Double>>() {
            @Override
            public int compare(Map.Entry<Long, Double> o1, Map.Entry<Long, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Collections.sort(cityInfoList, valueComparator);


        Map<Long, Double> map2 = new LinkedHashMap<>();
        for (Map.Entry<Long, Double> entry : cityInfoList) {
            map2.put(entry.getKey(), entry.getValue());
        }

        /**
         * Put the data into similarity array
         */
        for (Long key : map2.keySet()) {
            if (key.longValue() == userId){
                continue;
            }
            similarity[index++] = key.longValue();
        }


        return similarity;


    }
}
