package com.yecon.sound.setting.unitl;

public class SoundArray {
	public static final int EFFECT_EQ_CODE_POP = 0x01; //流行
	public static final int EFFECT_EQ_CODE_NORMAL = 0x02;//标准
	public static final int EFFECT_EQ_CODE_ROCK = 0x03; //摇滚
	public static final int EFFECT_EQ_CODE_CLASSIC = 0x04;//古典
	public static final int EFFECT_EQ_CODE_JAZZ = 0x05;//爵士
	public static final int EFFECT_EQ_CODE_LIVE = 0x07; //现场
	public static final int EFFECT_EQ_CODE_SOFT = 0x08; //柔和
	public static final int EFFECT_EQ_CODE_DANCE = 0x09; //柔和
	public static final int EFFECT_EQ_CODE_HIPHOP = 0x10; //嘻哈
	public static String MTKSettings = "com.yecon.sound.setting";
	public static int g_ganValues[] = { 0xFFFF3315, 0xFFFF3950, 0xFFFF404E,
			0xFFFF4827, 0xFFFF50F5, 0xFFFF5AD6, 0xFFFF65EB, 0xFFFF725A,
			0xFFFF804E, 0xFFFF8FF6, 0xFFFFA187, 0xFFFFB53C, 0xFFFFCB5A,
			0xFFFFE42A, 0x00000000, 0x00001F3C, 0x00004248, 0x0000699C,
			0x000095BB, 0x0000C73D, 0x0000FEC9, 0x00013D1C, 0x0001830A,
			0x0001D181, 0x0002298B, 0x00028C52, 0x0002FB27, 0x00037782,
			0x0004030A };

	public static int g_dryValues[] = { 0x00003314, 0x0000394F, 0x0000404D,
			0x00004826, 0x000050F4, 0x00005AD5, 0x000065EA, 0x00007259,
			0x0000804D, 0x00008FF5, 0x0000A186, 0x0000B53B, 0x0000CB59,
			0x0000E429, 0x00010000, 0x00011F3C, 0x00014248, 0x0001699C,
			0x000195BB, 0x0001C73D, 0x0001FEC9, 0x00023D1C, 0x0002830A,
			0x0002D181, 0x0003298B, 0x00038C52, 0x0003FB27, 0x00047782,
			0x0005030A };
	
	public static final int[][] gEQTypePos = {
			// CFG_EQ_ROCK 摇滚
			{ 0, 10, 8, 5, 0, -2, 0, 2, 4, 8, 10 },
			// CFG_EQ_POP 流行
			{ 0, -2, 0, 4, 8, 10, 8, 5, 1, -2, -4 },
			// CFG_EQ_LIVING 现场
			{ 0, 14, 12, 8, 2, -2, 0, 6, 10, 8, 4 },
			// CFG_EQ_DANCE //舞曲
			{ 0, 10, 9, 7, 4, 0, -3, -5, -3, -1, 0 },
			// CFG_EQ_SOFT //古典
			{ 0, 0, 0, 0, 0, 0, 0, -1, -2, -4, -5 },
			// CFG_EQ_SOFT //柔和
			{ 0, 5, 4, 3, 2, 1, -1, -3, -5, -7, -8 },
			// CFG_EQ_OFF //原声
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			// CFG_EQ_jazz //爵士
			{ 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7 },
			// CFG_EQ_hiphop //嘻哈
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			};

	// public static int Balance_au4TrimValue[] = { 0x0000A1E9, 0x0000AB81,
	// 0x0000B5AA, 0x0000C06E, 0x0000CBD5, 0x0000D7E9, 0x0000E4B4,
	// 0x0000F241, 0x0001009C, 0x00010FD0, 0x00011FEB, 0x000130FB,
	// 0x0001430D, 0x00015631, 0x00016A78, 0x00017FF2, 0x000196B2,
	// 0x0001AECB, 0x0001C852, 0x0001E35C, 0x00020000, 0x00021E57,
	// 0x00023E79, 0x00026083, 0x00028492, 0x0002AAC3, 0x0002D338,
	// 0x0002FE13, 0x00032B77, 0x00035B8C, 0x00038E7B, 0x0003C46E,
	// 0x0003FD93, 0x00043A1B, 0x00047A3A, 0x0004BE25, 0x00050616,
	// 0x0005524B, 0x0005A303, 0x0005F884, 0x00065316 };

	public static int Balance_au4TrimValue[] = { 0x00000000, 0x0000AB81,
			0x0000B5AA, 0x0000C06E, 0x0000CBD5, 0x0000D7E9, 0x0000E4B4,
			0x0000F241, 0x0001009C, 0x00010FD0, 0x00011FEB, 0x000130FB,
			0x0001430D, 0x00015631, 0x00016A78, 0x00017FF2, 0x000196B2,
			0x0001AECB, 0x0001C852, 0x0001E35C, 0x00020000, 0x00021E57,
			0x00023E79, 0x00026083, 0x00028492, 0x0002AAC3, 0x0002D338,
			0x0002FE13, 0x00032B77, 0x00035B8C, 0x00038E7B, 0x0003C46E,
			0x0003FD93, 0x00043A1B, 0x00047A3A, 0x0004BE25, 0x00050616,
			0x0005524B, 0x0005A303, 0x0005F884, 0x00065316 };

//	public static int LoudNess_gLoudNessGain[][] = {
//			{ 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000,0x00000000 },
//			{ 0x00100000, 0x00e0b3d9, 0x000f4e20, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0be81, 0x000f43b6, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0c9cb, 0x000f38b1, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0d5c0, 0x000f2d0a, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0e26a, 0x000f20b6, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0efd5, 0x000f13ae, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e0fe0b, 0x000f05e5, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 },
//			{ 0x00100000, 0x00e10d19, 0x000ef753, 0x001f5636, 0x00f0a807,0x005a9c78 } };
	
	
	public static int LoudNess_gLoudNessGain[][] = {
		    {0x00000000,0x00000000,0x00000000,0x00000000,0x00000000,0x00000000},
		    {0x00100000,0x00e0b3d9,0x000f4e20,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0be81,0x000f43b6,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0c9cb,0x000f38b1,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0d5c0,0x000f2d0a,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0e26a,0x000f20b6,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0efd5,0x000f13ae,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e0fe0b,0x000f05e5,0x001f5636,0x00f0a807,0x005a9c78},

		    {0x00100000,0x00e10d19,0x000ef753,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e11d0a,0x000ee7eb,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e12dee,0x000ed7a2,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e13fd2,0x000ec66c,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e152c6,0x000eb43b,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e166d8,0x000ea103,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e17c1c,0x000e8cb6,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e192a2,0x000e7743,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e1aa7d,0x000e609d,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e1c3c3,0x000e48b2,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e1de87,0x000e2f72,0x001f5636,0x00f0a807,0x005a9c78},
		    {0x00100000,0x00e1fae2,0x000e14cc,0x001f5636,0x00f0a807,0x005a9c78}
		};
	public static int ReverbCoef_live[] = { 0x180000, 0x7FFFFF, 0x29, 0x1F,
			0x17, 0x0D, 0x29, 0x1F, 0x17, 0x0D, 0x29, 0x1F, 0x17, 0x0D };
	public static int ReverbCoef_hall[] = { 0x300000, 0x7FFFFF, 0x4F, 0x3B,
			0x25, 0x13, 0x4F, 0x3B, 0x25, 0x13, 0x4F, 0x3B, 0x25, 0x13 };
	public static int ReverbCoef_concert[] = { 0x200000, 0x7FFFFF, 0x4F, 0x43,
			0x3B, 0x2F, 0x4F, 0x43, 0x3B, 0x2F, 0x4F, 0x43, 0x3B, 0x2F };
	public static int ReverbCoef_cave[] = { 0x600000, 0x7FFFFF, 0x3B, 0x2F,
			0x25, 0x17, 0x3B, 0x2F, 0x25, 0x17, 0x3B, 0x2F, 0x25, 0x17 };
	public static int ReverbCoef_bathroom[] = { 0x400000, 0x7FFFFF, 0x13, 0x11,
			0x0B, 0x07, 0x13, 0x11, 0x0B, 0x07, 0x13, 0x11, 0x0B, 0x07 };
	public static int ReverbCoef_arena[] = { 0x100000, 0x7FFFFF, 0x4F, 0x49,
			0x47, 0x43, 0x4F, 0x49, 0x47, 0x43, 0x4F, 0x49, 0x47, 0x43 };
	public static int ReverbCoef_off[] = { 0x000000, 0x000000, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
	public static int rUpmixGain_0[] = { 0x00000000, 0x00000000, 0x00000000,
			0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000 };
	public static int rUpmixGain_1[] = { 0x004CCCCC, 0x00199999, 0x00199999,
			0x004CCCCC, 0x00333333, 0x00333333, 0x00666666, 0x00666666 };
	public static int[] gEQTypeGain_off = { 0x00010000, 0x00000000, 0x00000000,
			0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000,
			0x00000000, 0x00000000, 0x00000000 };
	public static int[] gEQTypeGain_rock = { 0x00010000, 0x0002298B,
			0x0001830A, 0x0000C73D, 0x00000000, 0xFFFFCB5A, 0x00000000,
			0x00004248, 0x000095BB, 0x0001830A, 0x0002298B };
	public static int[] gEQTypeGain_pop = { 0x00010000, 0xFFFFCB5A, 0x00000000,
			0x000095BB, 0x0001830A, 0x0002298B, 0x0001830A, 0x0000C73D,
			0x00001F3C, 0xFFFFCB5A, 0xFFFFA187 };
	public static int[] gEQTypeGain_live = { 0x00010000, 0x0004030A,
			0x0002FB27, 0x0001830A, 0x00004248, 0xFFFFCB5A, 0x00000000,
			0x0000FEC9, 0x0002298B, 0x0001830A, 0x000095BB };
	public static int[] gEQTypeGain_dance = { 0x00010000, 0x0002298B,
			0x0001D181, 0x00013D1C, 0x000095BB, 0x00000000, 0xFFFFB53C,
			0xFFFF8FF6, 0xFFFFB53C, 0xFFFFE42A, 0x00000000 };
	public static int[] gEQTypeGain_classic = { 0x00010000, 0x00000000,
			0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000,
			0xFFFFE42A, 0xFFFFCB5A, 0xFFFFA187, 0xFFFF8FF6 };
	public static int[] gEQTypeGain_soft = { 0x00010000, 0x0000C73D,
			0x000095BB, 0x0000699C, 0x00004248, 0x00001F3C, 0xFFFFE42A,
			0xFFFFB53C, 0xFFFF8FF6, 0xFFFF725A, 0xFFFF65EB };
}
