## Configuração do Ambiente

### Pré-requisitos
- Java Development Kit (JDK) 17:
- IDE
  
1. Certifique-se de ter o JDK 17 instalado no seu sistema. Caso não possua o JDK 17 configurado na máquina, siga esses videos tutoriais para [instalar no Windows](https://www.youtube.com/watch?v=QekeJBShCy4) e [aqui para Linux](https://www.youtube.com/watch?v=iHZ4b1twvlg).
2. Baixe o projeto ou clone via git (git clone git@github.com:YohanDevPs/VersatChallenge.git).
3. Importe para sua IDE e atualize o projeto.

### O que o projeto faz:

**Datos de Entrada:** La función o programa debe tomar como entrada una lista de registros contables. Cada registro contiene información sobre la fecha, el concepto y el monto de una transacción.

**Salida Esperada:** A partir dos dados de entrada, o programa imprime informações sobre balance general, estado de resultados, índice de liquidez corriente y margen de beneficio neto.

**OBS**: Criei uma classe chamada `MockAccountingRecord.java`, cujo implementei um algoritmo para fornecer uma lista de dados validos para testarmos a aplicação. 

<details>
  <summary>Caso queira manipular o tamanho da lista modifique o tamanho desejado aqui:</summary>

  ![print](https://github.com/YohanDevPs/VersatChallenge/assets/87953006/3e453b91-e605-4df4-af66-e6614b8dda9a)

</details>

### Executando o projeto e retorno no console:

<details>
  <summary>Exemplo de saída:</summary>
  
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


