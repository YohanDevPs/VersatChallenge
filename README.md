## Configuração do Ambiente

### Pré-requisitos
- Kit de Desenvolvimento Java (JDK) 17:
- Ambiente de Desenvolvimento Integrado (IDE)
  
1. Certifique-se de ter o JDK 17 instalado no seu sistema. Se o JDK 17 não estiver configurado na sua máquina, siga estes tutoriais em vídeo para [instalar no Windows](https://www.youtube.com/watch?v=QekeJBShCy4) e [aqui para Linux](https://www.youtube.com/watch?v=iHZ4b1twvlg).
2. Faça o download do projeto ou clone-o via Git (git clone https://github.com/YohanDevPs/VersatChallenge.git).
3. Importe o projeto na sua IDE e atualize o projeto.

### Descrição do Projeto:

- Dados de Entrada: A função ou programa deve receber como entrada uma lista de registros contábeis. Cada registro contém informações sobre a data, o tipo (ativo corrente, ativo fixo, passivo corrente e passivo a longo prazo) e o valor de uma transação.

- Resultado Esperado: Com base nos dados de entrada, o programa imprime informações sobre o balanço geral, o estado de resultados, o índice de liquidez corrente e a margem de lucro líquido.

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


