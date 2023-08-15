package com.example.ufrpelogin

import com.example.ufrpelogin.db.DBHelper
import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.ufrpelogin.databinding.ActivityFrequenciaAlunoBinding
import java.text.SimpleDateFormat
import java.util.Date

class FrequenciaActivity : AppCompatActivity() {

        private lateinit var binding: ActivityFrequenciaAlunoBinding
        private lateinit var bluetoothAdapter: BluetoothAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityFrequenciaAlunoBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
            bluetoothAdapter = bluetoothManager.adapter

            binding.buttonVoltar.setOnClickListener {
                finish()
            }

            binding.confirmButton.setOnClickListener {
                toggleBluetooth()
            }
        }

        private fun toggleBluetooth() {
            if (!bluetoothAdapter.isEnabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
            } else {
                Toast.makeText(this, "Bluetooth já está ligado.", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_ENABLE_BT) {
                if (resultCode == RESULT_OK) {
                    confirmarHost(bluetoothAdapter)
                } else {
                    Toast.makeText(this, "Bluetooth não foi ativado.", Toast.LENGTH_SHORT).show()
                }
            }
        }



        companion object {
            private const val REQUEST_ENABLE_BT = 1
        }

    fun listaPareados(bluetoothAdapter: BluetoothAdapter): Set<BluetoothDevice> {
        val pareados = if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return emptySet()
        } else {
            bluetoothAdapter.bondedDevices
        }
        return pareados
    }


    private fun confirmarHost(bluetoothAdapter: BluetoothAdapter) {
        val pareados = listaPareados(bluetoothAdapter)
        val dbHelper = DBHelper(this)

        for (dispositivo in pareados) {
            if (dbHelper.isProfessorMac(dispositivo.address.toString())) { //Verifica com MAC do Host
                Toast.makeText(this, "Pareamento com Host Confirmado", Toast.LENGTH_SHORT).show()
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                dbHelper.inserirFrequencia(obterNomeTabelaFrequencia(), dispositivo.name, dispositivo.address)
                binding.status.setText("Frequência Realizada com Sucesso") // Atualiza o TextView
                binding.confirmButton.setBackgroundResource(R.drawable.baseline_bluetooth_connected_24_white)
                binding.status.setBackgroundResource(R.drawable.bg_btn_blue)
                return
            }
        }
        Toast.makeText(this, "Pareamento com Host não identificado", Toast.LENGTH_SHORT).show()
    }


    fun obterNomeTabelaFrequencia(): String {
        val formatoData = SimpleDateFormat("yyyyMMdd_HHmmss") // Define o formato desejado da data
        val dataAtual = Date()
        val dataFormatada = formatoData.format(dataAtual)
        return "frequencia_$dataFormatada"
    }
}









