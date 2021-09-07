package cubes.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.dao.StickerDAO;
import cubes.main.entity.Sticker;

@Service
public class StickerServiceImpl implements StickerService {

	@Autowired
	private StickerDAO stickerDAO;
	
	@Transactional
	@Override
	public List<Sticker> getStickerList() {
		
		
		return stickerDAO.getStickerList();
	}

	@Transactional
	@Override
	public void saveSticker(Sticker sticker) {
		
		
		stickerDAO.saveSticker(sticker);
		
	}

	@Transactional
	@Override
	public void getStickerDelete(int id) {
		
		
		stickerDAO.getStickerDelete(id);
		
	}

	@Transactional
	@Override
	public Sticker getStickerById(int id) {
		
		return stickerDAO.getStickerById(id);
	}
	

}
