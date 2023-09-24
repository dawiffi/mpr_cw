public class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name){
        if (age < 0){
            throw new InvalidAgeException("Wiek nie moze byc mniejszy niz 0");
        }
        if (age > 100){
            throw new InvalidAgeException("Wiek nie moze byc wiekszy niz 100");
        }

        this.age = age;
        this.name = name;
    }

    public Person(String name){
        this.name = name;
    }

    public void setAge(Integer age) {
        if (age < 0){
            throw new InvalidAgeException("Wiek nie moze byc mniejszy od 0");
        }

        if (age > 100){
            throw new InvalidAgeException("Wiek nie moze byc wiekszy od 100");
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
