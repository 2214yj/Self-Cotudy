/*
"테스트 코드는 돌아가지만 효율성이 떨어지는 코드"
=> 개선 방안:
 */


import java.util.ArrayList;
class Solution {
    public ArrayList<Integer>  solution(String[] info, String[] query) {

        ArrayList<Apply> apply = new ArrayList<Apply>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(String obj: info){
            String[] str = obj.split(" ");
            apply.add(new Apply(str[0],str[1],str[2],str[3],str[4]));
        }

        for(String q: query){
            String[] str = q.split(" ");
            Apply qu = new Apply(str[0],str[2],str[4],str[6],str[7]);
            result.add(0);
            for(Apply a: apply){
                if(a.compare(qu)){
                    int temp = result.get(result.size()-1) +1;
                    result.set(result.size()-1,temp);
                }
            }
        }

        return result;
    }
}

class Apply{
    String language;
    String position;
    String career;
    String food;
    int score;

    Apply(String language,String position, String career, String food,String score){
        this.language = language;
        this.position = position;
        this.career = career;
        this.food = food;
        this.score = Integer.parseInt(score);
    }

    boolean compare(Apply b){
        if(b.language.equals("-")||(b.language.equals(this.language))){
            if(b.position.equals("-")||(b.position.equals(this.position))){
                if(b.career.equals("-")||(b.career.equals(this.career))){
                    if(b.food.equals("-")||(b.food.equals(this.food))){
                        return this.score >= b.score;
                    }
                }
            }
        }
        return false;
    }

}

