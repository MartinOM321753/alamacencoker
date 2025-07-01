package utez.edu.mx.unidad3.models.cede;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.unidad3.utlis.APIResponse;

@RestController
@RequestMapping("/api/cede")
@Tag(name = "Controlador de sedes", description = "Operaciones relacionadas con sedes")

public class CedeController {
    @Autowired
    private CedeService cedeService;

    @GetMapping(value = {"","/"})
    @Operation(summary = "Obtener sedes", description = "Retorna todas las sedes registradas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de todas las sedes",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> findAll(){
        APIResponse response = cedeService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sede", description = "Retorna una sede específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sede encontrada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> findById(@PathVariable("id") Long id){
        APIResponse response = cedeService.findById(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping(value = {"","/"})
    @Operation(summary = "Registrar sede", description = "Crea una nueva sede en el sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Sede creada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al crear la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> save(@RequestBody Cede cede){
        APIResponse response = cedeService.save(cede);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping(value = {"","/"})
    @Operation(summary = "Actualizar sede", description = "Actualiza la información de una sede existente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sede actualizada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al actualizar la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> update(@RequestBody Cede cede){
        APIResponse response = cedeService.update(cede);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping(value = {"","/"})
    @Operation(summary = "Eliminar sede", description = "Elimina una sede del sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Sede eliminada exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No se encontró la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al eliminar la sede",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class))
            )
    })
    public ResponseEntity<APIResponse> remove(@RequestBody Cede cede){
        APIResponse response = cedeService.remove(cede);
        return new ResponseEntity<>(response, response.getStatus());
    }
}