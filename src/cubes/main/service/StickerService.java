package cubes.main.service;

import java.util.List;

import cubes.main.entity.Sticker;

public interface StickerService {
	
	public List<Sticker> getStickerList();
	public void saveSticker(Sticker sticker);
	public void getStickerDelete(int id);
	public Sticker getStickerById(int id);

}
