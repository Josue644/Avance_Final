package com.Trabajo.Final.util;

import com.Trabajo.Final.dto.MatriculaDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelExporter {

    public static Workbook exportarMatrículas(List<MatriculaDTO> lista) {
        Workbook workbook = new XSSFWorkbook();

        // Crear hoja Apoderados
        var sheetApoderados = workbook.createSheet("Apoderados");
        String[] columnasApoderado = {
            "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "DNI",
            "Correo", "Dirección", "Teléfono"
        };

        // Encabezado Apoderados
        Row headerApoderado = sheetApoderados.createRow(0);
        for (int i = 0; i < columnasApoderado.length; i++) {
            headerApoderado.createCell(i).setCellValue(columnasApoderado[i]);
        }

        // Llenar datos Apoderados
        int rowNum = 1;
        for (MatriculaDTO m : lista) {
            Row row = sheetApoderados.createRow(rowNum++);
            row.createCell(0).setCellValue(m.getId() != null ? m.getId() : 0);
            row.createCell(1).setCellValue(m.getNombreApoderado() != null ? m.getNombreApoderado() : "");
            row.createCell(2).setCellValue(m.getApellidoPaterno() != null ? m.getApellidoPaterno() : "");
            row.createCell(3).setCellValue(m.getApellidoMaterno() != null ? m.getApellidoMaterno() : "");
            row.createCell(4).setCellValue(m.getNumeroDocumentoApoderado() != null ? m.getNumeroDocumentoApoderado() : "");
            row.createCell(5).setCellValue(m.getCorreoElectronico() != null ? m.getCorreoElectronico() : "");
            row.createCell(6).setCellValue(m.getDireccion() != null ? m.getDireccion() : "");
            row.createCell(7).setCellValue(m.getTelefono() != null ? m.getTelefono() : "");
        }

        // Ajustar ancho columnas Apoderados
        for (int i = 0; i < columnasApoderado.length; i++) {
            sheetApoderados.autoSizeColumn(i);
        }

        // Crear hoja Alumnos
        var sheetAlumnos = workbook.createSheet("Alumnos");
        String[] columnasAlumno = {
            "Nombre", "Apellido Paterno", "Apellido Materno", "DNI",
            "Nivel", "Grado", "Sede"
        };

        // Encabezado Alumnos
        Row headerAlumno = sheetAlumnos.createRow(0);
        for (int i = 0; i < columnasAlumno.length; i++) {
            headerAlumno.createCell(i).setCellValue(columnasAlumno[i]);
        }

        // Llenar datos Alumnos
        rowNum = 1;
        for (MatriculaDTO m : lista) {
            Row row = sheetAlumnos.createRow(rowNum++);
            row.createCell(0).setCellValue(m.getNombreAlumno() != null ? m.getNombreAlumno() : "");
            row.createCell(1).setCellValue(m.getApellidoPaterno() != null ? m.getApellidoPaterno() : "");
            row.createCell(2).setCellValue(m.getApellidoMaterno() != null ? m.getApellidoMaterno() : "");
            row.createCell(3).setCellValue(m.getNumeroDocumentoAlumno() != null ? m.getNumeroDocumentoAlumno() : "");
            row.createCell(4).setCellValue(m.getNivel() != null ? m.getNivel() : "");
            row.createCell(5).setCellValue(m.getGrado() != null ? m.getGrado() : "");
            row.createCell(6).setCellValue(m.getSede() != null ? m.getSede() : "");
        }

        // Ajustar ancho columnas Alumnos
        for (int i = 0; i < columnasAlumno.length; i++) {
            sheetAlumnos.autoSizeColumn(i);
        }

        return workbook;
    }
}
