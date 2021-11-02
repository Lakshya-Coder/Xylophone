package com.lakshyagupta7089.xylophone

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window.FEATURE_NO_TITLE
import android.view.WindowManager
import com.lakshyagupta7089.xylophone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val lft_vol = 1.0F
    private val rgt_vol = 1.0F
    private val loop = 0
    private val prty = 0
    private val NORMAL_PLAY_RATE = 1.0F

    private var mSoundPool: SoundPool? = null

    private var mCSoundId1 = 0
    private var mDSoundId2 = 0
    private var mESoundId3 = 0
    private var mFSoundId4 = 0
    private var mGSoundId5 = 0
    private var mASoundId6 = 0
    private var mBSoundId7 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        mSoundPool = SoundPool(sim_sound, AudioManager.STREAM_MUSIC, 0)
        mSoundPool =
            SoundPool.Builder()
                .setMaxStreams(7)
                .build()

        mCSoundId1 = mSoundPool?.load(
            applicationContext,
            R.raw.note1_c, 1
        )!!
        mDSoundId2 = mSoundPool?.load(
            applicationContext,
            R.raw.note2_d, 1
        )!!
        mESoundId3 = mSoundPool?.load(
            applicationContext,
            R.raw.note3_e, 1
        )!!
        mFSoundId4 = mSoundPool?.load(
            applicationContext,
            R.raw.note4_f,
            1
        )!!
        mGSoundId5 = mSoundPool?.load(
            applicationContext,
            R.raw.note5_g,
            1
        )!!
        mASoundId6 = mSoundPool?.load(
            applicationContext,
            R.raw.note6_a,
            1
        )!!
        mBSoundId7 = mSoundPool?.load(applicationContext, R.raw.note7_b, 1)!!

        binding.aKey.setOnClickListener(this)
        binding.bKey.setOnClickListener(this)
        binding.cKey.setOnClickListener(this)
        binding.dKey.setOnClickListener(this)
        binding.eKey.setOnClickListener(this)
        binding.fKey.setOnClickListener(this)
        binding.gKey.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.aKey.id -> {
                playSound(mASoundId6)
            }
            binding.bKey.id -> {
                playSound(mBSoundId7)
            }
            binding.cKey.id -> {
                playSound(mCSoundId1)
            }
            binding.dKey.id -> {
                playSound(mDSoundId2)
            }
            binding.eKey.id -> {
                playSound(mESoundId3)
            }
            binding.fKey.id -> {
                playSound(mFSoundId4)
            }
            binding.gKey.id -> {
                playSound(mGSoundId5)
            }
        }
    }

    private fun playSound(soundId: Int) {
        mSoundPool?.play(soundId, lft_vol, rgt_vol, prty, loop, NORMAL_PLAY_RATE)
    }
}