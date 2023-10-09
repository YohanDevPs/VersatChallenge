## Configuración del Entorno

### Requisitos Previos
- Kit de Desarrollo Java (JDK) 17:
- Entorno de Desarrollo Integrado (IDE)
  
1. Asegúrate de tener instalado el JDK 17 en tu sistema. Si no tienes el JDK 17 configurado en tu máquina, sigue estos tutoriales en video para [instalar en Windows](https://www.youtube.com/watch?v=QekeJBShCy4) e [aqui para Linux](https://www.youtube.com/watch?v=iHZ4b1twvlg).
2. Descarga el proyecto o clónalo a través de Git (git clone git@github.com:YohanDevPs/VersatChallenge.git).
3. Importa el proyecto en tu IDE y actualiza el proyecto.

### Descripción del Proyecto:

- Datos de Entrada: La función o programa debe tomar como entrada una lista de registros contables. Cada registro contiene información sobre la fecha, el concepto y el monto de una transacción.

- Resultado Esperado: A partir de los datos de entrada, el programa imprime información sobre el balance general, el estado de resultados, el índice de liquidez corriente y el margen de beneficio neto.

**NOTA:** Creé una clase llamada `MockAccountingRecord.java`, en la cual implementé un algoritmo para proporcionar una lista de datos válidos para probar la aplicación.

<details>
  <summary>Si deseas modificar el tamaño de la lista, hazlo aquí:</summary>

  ![print](https://github.com/YohanDevPs/VersatChallenge/assets/87953006/3e453b91-e605-4df4-af66-e6614b8dda9a)

</details>

### Ejecución del Proyecto y Resultados en la Consola:

<details>
  <summary>Ejemplo de salida:</summary>
  
```
 ---- BALANCE GENERAL ---- 
Activos Currientes
Efectivos: $ 1.038.117,47
Dinero actual: $ 1.063.707,34
Cuentas para recibir: $ 1.014.489,89
Total Activos Currientes: $ 3.116.314,70 

Activos fijos
Activos diferidos: $ 1.038.907,22
Propriedades: $ 1.057.698,02
Equipos: $ 1.044.842,03
Total Activos fijos: $ 3.141.447,27 

TOTAL ACTIVOS: $ 6.257.761,97

Passivos currientes
Provisión de reserva: $ 1.066.548,72
Factura para pagar: $ 1.004.701,60
Impuesto: $ 1.032.775,92
Total Passivos currientes: $ 3.104.026,24 

Passivos a largo plazo
Arrendamientos financieros: $ 1.040.846,17
Bonificaciones: $ 1.025.003,17
Préstamo a largo plazo: $ 1.044.745,75
Total Passivos a largo plazo: $ 3.110.595,09 

TOTAL PASSIVO: $ 6.214.621,33


----- ESTATO DE RESULTADO -----
Ingressos totales: $ 6.257.761,97
Gastos totales: $ 6.214.621,33
Beneficio neto: $ 43.140,64


---- ANÁLISE DE LIQUIDEZ ----
Liquidez Corrente: 1,00 o 100%


---- ANÁLISIS DE RENTABILIDAD ----
Margem de benefício neto: 1.00%
```

</details>


