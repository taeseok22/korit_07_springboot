package com.example.cardatabase4.zz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 요구사항 명세서:
//
//학생의 정보는 Map<String, Object> 형태로 관리하며, 이름(name)과 성적(scores)을 키로 가집니다.
//성적(scores)은 다시 Map<String, Integer> 형태로, 과목명을 키로, 점수를 값으로 가집니다.
//calculateAverage 메서드는 학생의 성적 Map을 인자로 받아, 모든 과목의 평균 점수를 계산하여 반환합니다.
//main 메서드에서는 여러 학생의 정보를 List에 담고, 반복문을 사용하여 각 학생의 이름과 평균 점수를 "실행 예"와 같이 출력해야 합니다.


public class GradeCalculator {

    public static double calculateAverage(Map<String, Integer> scores) {
        double sum = 0;
        // TODO: scores 맵의 모든 점수를 합산하여 합계를 구하는 코드를 작성하시오.
        for (int score : scores.values()) {
            sum += score;
        }
        // TODO: 합산된 점수를 과목 수로 나누어 평균을 계산하고 반환하는 코드를 작성하시오.
        if (scores.isEmpty()) {
            return 0.0;
        }
        return sum / scores.size();
        // 단, 과목이 없을 경우 0점을 반환해야 합니다.
    }

    public static void main(String[] args) {
        List<Map<String, Object>> students = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name", "홍길동");
        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("국어", 85);
        scores1.put("영어", 90);
        scores1.put("수학", 95);
        student1.put("scores", scores1);
        students.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name", "김철수");
        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("국어", 75);
        scores2.put("영어", 80);
        scores2.put("과학", 88);
        student2.put("scores", scores2);
        students.add(student2);

        // TODO: students 리스트를 순회하며 각 학생의 이름과 평균 점수를 출력하시오.
        // calculateAverage 메서드를 반드시 사용해야 합니다.
        for (Map<String, Object> student : students) {
            String name = (String) student.get("name");
            Map<String, Integer> scores = (Map<String, Integer>) student.get("scores");
            double average = calculateAverage(scores);
            System.out.println("학생 이름: " + name + ", 평균 점수: " + average);
        }
    }
}