using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using ListenToThePlaceBackend.Models;

namespace TodoApi.Controllers
{
    [Route("api/[controller]")]
    public class AudioTrackController : ControllerBase
    {
        private readonly ListenToThePlaceDBContext _context;

        public AudioTrackController(ListenToThePlaceDBContext context)
        {
            _context = context;

            if (_context.AudioTracks.Count() == 0)
            {
                _context.AudioTracks.Add(new AudioTrackItem { Name = "Imagine", Performer = "John Lennon", Latitude = 52.2201353, Longtitude = 21.0118582 });
                _context.SaveChanges();
            }
        }

        [HttpGet]
        public List<AudioTrackItem> GetAll()
        {
            return _context.AudioTracks.ToList();
        }

        [HttpGet("{id}", Name = "GetAudioTrack")]
        public IActionResult GetById(long id)
        {
            var item = _context.AudioTracks.Find(id);
            if (item == null)
            {
                return NotFound();
            }
            return Ok(item);
        }
    }
}
