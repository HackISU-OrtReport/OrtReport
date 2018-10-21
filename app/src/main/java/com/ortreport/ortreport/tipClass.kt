package com.ortreport.ortreport

class Tip {
    var tipIDNumber: Int? = null
    var tipBodyText: String? = null

    constructor() {

    }

    constructor(id: Int, body: String) {
        this.tipIDNumber = id
        this.tipBodyText = body
    }
}