package org.roberto.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Roberto
 *
 * Es una copia exacta de StudentBasico
 * sólo añado la anotación "@JsonIgnoreProperties(ignoreUnknown=true)"
 * para evitar que salten excepciones
 * durante el binding desde Json hacia el POJO
 * en caso de que hayan propiedades en el Json no declaradas en el POJO 
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class StudentBasicoIgnoraPropiedadesJson extends StudentBasico {
}