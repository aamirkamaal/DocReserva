package com.example.docreserva.model

data class DocModel(var image: Int, var text: String)
data class DocDetailModel(
    var image: Int,
    var docName: String,
    var degree: String,
    var docType: String,
    var exp: String,
    var address: String,
    var fee: String,
    var rating: String
)
