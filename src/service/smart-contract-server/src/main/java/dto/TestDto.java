package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private int intVar;
    private long longVar;
    private String stringVar;
    private List<DetailTestDto> detail;

//    public TestDto generateNewDto(int intVar, long longVar, String stringVar) {
//        return TestDto.builder().
//                intVar(intVar).
//                longVar(longVar).
//                stringVar(stringVar).
//                detail(new ArrayList<DetailTestDto>(0))
//                .build();
//    }

}
