package com.softuni.cardealer.domain.dtos.importXmls;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDtoXml {
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;
}
