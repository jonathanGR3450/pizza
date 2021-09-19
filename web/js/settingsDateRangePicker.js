$('.datetimepicker').daterangepicker({
        'locale': {
            'format': "DD/MM/YYYY hh:mm A",
            'applyLabel': "Aplicar",
            'cancelLabel': "Cancelar",
            'daysOfWeek': [
                "Do",
                "Lu",
                "Ma",
                "Mi",
                "Ju",
                "Vi",
                "Sa"
            ],
            'monthNames': [
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
            ],
            'firstDay': 1
        },
        "singleDatePicker": true,
        "timePicker": true,
        "timePicker24Hour": true,
    });