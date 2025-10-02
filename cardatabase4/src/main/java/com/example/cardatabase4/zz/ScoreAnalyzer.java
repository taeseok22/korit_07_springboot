package com.example.cardatabase4.zz;
// 설명: 주어진 정수 배열에서 특정 점수 이상인 학생이 몇 명인지 계산하는 프로그램을 작성하세요. for 문과 if 문을 사용하여 배열을 순회하고 조건을 확인해야 합니다.
//요구사항 명세서:
//countPassingStudents 메서드는 점수 배열 scores와 통과 기준 점수 passingScore를 인자로 받습니다.
//메서드는 scores 배열을 순회하며 passingScore 이상인 점수의 개수를 셉니다.
//계산된 학생 수를 반환합니다.
//main 메서드에서 scores 배열과 passingScore를 정의하고, countPassingStudents 메서드를 호출하여 결과를 "실행 예"와 같이 출력하세요.
public class ScoreAnalyzer {

    public int countPassingStudents(int[] scores, int passingScore) {
        int passingStudentsCount = 0;
        // TODO: for문을 사용하여 scores 배열을 순회하고,
        // if문을 사용하여 passingScore 이상인 학생 수를 세는 코드를 작성하시오.
        for (int i = 0 ; i < scores.length; i++)
            if (scores[i] >= passingScore) {
                passingStudentsCount++;
            }
        return passingStudentsCount;
    }

    public static void main(String[] args) {
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        int[] scores = {88, 95, 72, 68, 77, 91, 60};
        int passingScore = 75;
        // 75점 이상으로 통과한 학생은 4명입니다.
        // TODO: countPassingStudents 메서드를 호출하고 결과를 출력하시오.
        int passingStudentsCount = analyzer.countPassingStudents(scores, passingScore);
        System.out.println(passingScore + "점 이상으로 통과한 학생은 "+ passingStudentsCount + "명 입니다.");
    }
}