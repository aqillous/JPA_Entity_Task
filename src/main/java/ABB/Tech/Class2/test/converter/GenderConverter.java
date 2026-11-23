package ABB.Tech.Class2.test.converter;

import ABB.Tech.Class2.test.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        if (gender == null) {
            return 0;
        }
        return gender.getDb_code();
    }

    @Override
    public Gender convertToEntityAttribute(Integer db_code) {
        return (db_code != null && db_code != 0) ? Gender.fromDbCode(db_code) : null;
    }
}
