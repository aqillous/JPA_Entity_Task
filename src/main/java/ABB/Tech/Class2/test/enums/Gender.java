package ABB.Tech.Class2.test.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {
    MALE(1),
    FEMALE(2);

    private final Integer db_code;

    Gender(Integer db_code) {
        this.db_code = db_code;
    }

    public static Gender fromDbCode(Integer db_code) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getDb_code().equals(db_code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid db_code: " + db_code));
    }
}
