package com.softuni.cardealer.domain.dtos.exportXmls;

import com.softuni.cardealer.domain.dtos.export.PartsExportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarPartsExportRootDtoXml {
    @XmlElement(name = "part")
    private List<CarPartsExportDto> parts;
}
