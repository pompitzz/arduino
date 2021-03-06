package me.sun.arduino.controller;

import lombok.RequiredArgsConstructor;
import me.sun.arduino.domain.MeasureValue;
import me.sun.arduino.service.MeasureValueService;
import me.sun.arduino.service.WindowService;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableJpaAuditing
@RestController
@RequiredArgsConstructor
public class MeasureValueController {

    private final MeasureValueService measureValueService;
    private final WindowService windowService;

    @GetMapping("/values/{name}")
    public List<MeasureValue> findValues(@PathVariable("name") String name){
        return measureValueService.findMeasureValues(name);
    }

    @GetMapping("/values/set")
    public String saveMeasure(@RequestParam(defaultValue = "123") String temp,
                              @RequestParam(defaultValue = "123") String humi,
                              @RequestParam(defaultValue = "123") String isRain,
                              @RequestParam(defaultValue = "123") String fineDust) {
        if (fineDust.startsWith("-")) return "첫값은 생략";
        MeasureValue measureValue = MeasureValue.builder()
                .temperature(temp)
                .humidity(humi)
                .isRain("true".equals(isRain))
                .fineDust(fineDust)
                .build();
        measureValueService.save(measureValue);
        windowService.changeWindowStateByMeasureValue(measureValue);
        return "저장 성공";
    }

}
