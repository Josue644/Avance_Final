package com.Trabajo.Final.service;

import com.Trabajo.Final.dto.MatriculaDTO;
import com.Trabajo.Final.util.ExcelExporter;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    private final DatosMatriculaService datosMatriculaService;

    public ExcelService(DatosMatriculaService datosMatriculaService) {
        this.datosMatriculaService = datosMatriculaService;
    }

    public void exportar(HttpServletResponse response) throws IOException {
        List<MatriculaDTO> lista = datosMatriculaService.obtenerMatrículas();

        Workbook workbook = ExcelExporter.exportarMatrículas(lista);

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
